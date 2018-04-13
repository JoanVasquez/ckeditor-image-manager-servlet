package ckeditor.image;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "ImageManager", urlPatterns = { "/imageManager.co" })
public class ImageManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultiPart;
	private String uploadPath;
	private int maxFileSize = 50 * 1024 * 1024;
	private Map<String, Object> result = new HashMap<>();
	private Map<String, String> errors = new HashMap<>();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

		uploadPath = request.getSession().getServletContext().getRealPath("/uploads");
		
		if (request.getMethod().equalsIgnoreCase("POST"))
			this.saveImage(request, response);
		else if (request.getMethod().equalsIgnoreCase("GET"))
			this.getImages(request, response);

	}

	private void saveImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		isMultiPart = ServletFileUpload.isMultipartContent(request);
		
		System.out.println("saveImage");
		try (PrintWriter out = response.getWriter()) {
			try {
				if (!isMultiPart)
					return;
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				File dir = new File(uploadPath);
				if (!dir.exists())
					dir.mkdirs();

				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iterator = fileItems.iterator();

				if (iterator.hasNext()) {
					FileItem fileItem = iterator.next();
					if (!fileItem.isFormField()) {
						int ran = (int) (Math.random() * 5000) + 1;
						String fileName = ran + fileItem.getName();
						String filePath = uploadPath + File.separator + fileName;
						File file = new File(filePath);
						fileItem.write(file);
						String url = request.getScheme() + "://" + request.getServerName() + ":"
								+ request.getServerPort() + request.getContextPath() + "/uploads/" + fileName;

						result.put("uploaded", 1);
						result.put("fileName", fileName);
						result.put("url", url);
					}
				}

				upload.setSizeMax(maxFileSize);
			} catch (Exception e) {
				errors.put("message", e.getMessage());
				result.put("error", errors);
			}
			String json = new ObjectMapper().writeValueAsString(result);
			out.println(json);
		}
	}

	private void getImages(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try (PrintWriter out = response.getWriter()) {
			List<String> images = new ArrayList<>();
			
			try {
				File folder = new File(uploadPath);
				File[] listOfFiles = folder.listFiles();
				
				for (File f : listOfFiles) {
					if (f.isFile()) {
						String url = request.getScheme() + "://" + request.getServerName() + ":"
								+ request.getServerPort() + request.getContextPath() + "/uploads/" + f.getName();
						images.add(url);
					}
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			String json = new ObjectMapper().writeValueAsString(images);
			out.println(json);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
