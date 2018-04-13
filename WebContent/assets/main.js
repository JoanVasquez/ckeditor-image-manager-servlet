$(document).ready(function(){
	var Main = function(){
		
		Main.prototype.loadImages = function(){
			$.ajax({
				url: 'http://localhost:8080/CKEditorImagesServlet/imageManager.co',
				type: 'GET',
				success: function(arrayImgs){
					var imgContainer = $('#img-container');
					var urls = JSON.parse(arrayImgs);
					console.log(urls)
					$.each(urls, function(i, val){
						imgContainer.append('<div class="col-md-3">' + 
							'<a href="javascript:void(0)">' + 
							'<div class="thumbnail">' +
							'<img src="'+val+'" class="imgurls">' +
							'</div' + 
							'</a>' + 
							'</div>')
					});
					$('.imgurls').each(function(index){
						$(this).on('click', function(){
							var src = $(this).attr('src');
							main.returnImgUrl(src);
						});
					});
				}
			});
			
			Main.prototype.returnImgUrl = function(url){
				let funcNum = main.getUrlParam('CKEditorFuncNum');
				var fileUrl = url;
				window.opener.CKEDITOR.tools.callFunction(funcNum, fileUrl);
				window.close();
			}
			
			Main.prototype.getUrlParam = function(paramName){
				var reParam = new RegExp('(?:[\?&]|&)' + paramName + '=([^&]+)', 'i');
				var match = window.location.search.match(reParam);
				return (match && match.length > 1) ? match[1] : null;
			}
		}
		
	}
	
	
	var main = new Main();
	main.loadImages();
});