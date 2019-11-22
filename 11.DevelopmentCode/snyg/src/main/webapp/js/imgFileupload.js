 ~(function(win){
	var ImgUploadeFiles = function(obj,fn){
		var _this = this;
		this.bom = document.querySelector(obj);
		if(fn) fn.call(_this);
		this.ready();
	};
	ImgUploadeFiles.prototype = {
		init : function(o){
			this.MAX = o.MAX || 5;
			this.callback = o.callback;
			this.MW = o.MW || 10000;
			this.MH = o.MH || 10000;
			this.FileSize=o.FileSize || 4194304;
		},
		ready : function(){
		  	var htmls = '<input type="file" name="imgFiles" id="imgFiles" class="imgFiles" style="display: none" accept="image/jpeg,image/jpg,image/png" multiple>'+
				'<div class="imgAll">'+
			'    <ul style="padding-left: 0px;">'+
			'    </ul>'+
			'</div>'+
	  		'<div class="upload_img imgClick">'+
                '<span class="add"></span>'+
                '<span class="img_len"><i>0</i>/'+this.MAX+'</span>'+
            '</div>';
			
			var _self = this;
			this.dom = document.createElement('div');
			this.dom.className = 'imgFileUploade';
			this.dom.innerHTML = htmls;
			this.bom.appendChild(this.dom);
			this.files = this.bom.querySelector('.imgFiles');
			this.fileClick = this.bom.querySelector('.imgClick');
			this.fileBtn(this.fileClick,this.files);
 		},
		fileBtn : function(c,f){
			var _self = this;
			var _imgAll = $(c).parent().find('.imgAll ul');
			$(c).off().on('click',function(){
				$(f).click();
                $(f).off().on('change',function(){
					var _this = this;
					_private.startUploadImg(_imgAll,_this.files,_self.MAX,_self.callback,_self.MW,_self.MH,_self.FileSize);
				});
			});
		}
	};
	var _dataArr = [];
	var _private = {
		startUploadImg : function(o,files,MAX,callback,W,H,FileSize){			
			_dataArr.length = 0;
			var _this = this;
			var fileImgArr = [];			
			
			if(files.length > MAX ){
				alert('图片数量为 '+ MAX +' 张以内');
				return false;
			};
			var lens = $(o).find('li').length ;
			if(lens >= MAX ){
				alert('图片数量为 '+ MAX +' 张以内');
				return false;
			};

			for(var i=0,file;file=files[i++];){
				if(file.size>=FileSize )
				{
					alert('图片名称： '+ file.name +'\r单个图片不超过 '+ parseInt(FileSize/1024/1024)+'MB ')
					continue;
				}
 				var reader = new FileReader();
				reader.onload = (function(file){
					return function(ev){
						var image = new Image();  
						image.onload=function(){  
					        var width = image.width;  
					        var height = image.height;							
					        fileImgArr.push({
								fileSrc : ev.target.result,
								fileName : file.name,
								fileSize : file.size,
								height : height,
								width : width
							});
					    };  
					     image.src= ev.target.result; 
 					};
				})(file);
				reader.readAsDataURL(file);
			}
			//创建分时函数
			var imgTimeSlice = _this.timeChunk(fileImgArr,function(file){
				if(file.width > W || file.height > H){
	            	alert('图片大小超过 '+W+'*'+H+' px');
	            	return false;
	            }
				//调用图片类
				var up = new ImgFileupload(o,file.fileName,file.fileSrc,file.fileSize,callback,MAX);
				up.init();
			},1);
			imgTimeSlice(); //调用分时函数
		},
		timeChunk : function(arr, fn, count) {
            var obj, t;
            var len = arr.length;
            var start = function() {
                for (var i = 0; i < Math.min(count || 1, arr.length); i++) {
                    var obj = arr.shift();
                    fn(obj)
                }
            };
            return function() {
                t = setInterval(function() {
                    if (arr.length === 0) {
                        return clearInterval(t);
                    }
                    start();
                },200)
            }
        }
	};

	var ImgFileupload = function(b,imgName,imgSrc,imgSize,callback,MAX){
		this.b = b;
		this.imgName = imgName;
		this.imgSize = imgSize;
		this.imgSrc = imgSrc;
		this.callback = callback;
		this.MAX=MAX;
	};
	var _delId = 0; //删除id用于判断删除个数
	ImgFileupload.prototype.init =function() {
		_delId++;
		var _self = this;
		this.dom = document.createElement('li');
		var _index =_delId; 
		if(_index>0)
		{
			_index=_index-1;
		}
		
		this.dom.innerHTML = '    <img src="" alt="" data-src="'+this.imgSrc +'" class="imsg">' +'<input type="hidden" name="uploadPicList['+_index+']" id="pic'+_delId+'" value="'+this.imgSrc+'">'+ '    <i class="delImg"></i>';
		$(this.dom).attr({'data-delId':_delId,'data-delName':this.imgName});				
		if($(".imgAll li").length>=this.MAX){		     
	        alert('图片数量为 '+ this.MAX +' 张以内');
			return false;
	    }else{
	    	$(this.b).append(this.dom);	
	    }
		var _Img = new Image();
		_Img.src = $(this.dom).find('img').attr('data-src');
		_Img.onload = function(){
			$(_self.dom).find('img').attr('src',_Img.src);
		}
		_dataArr.push({'delId' :_delId,src :  this.imgSrc});
		_self.callback(_dataArr);
		$(".img_len").find("i").text($(".imgAll li").length);
  		var _delAll = $(this.b).find('.delImg');
		for(var i=0;i<_delAll.length;i++){
			$(_delAll[i]).off().on('click',function(){				
				$(this).parent().fadeOut('slow',function(){					
					$(this).remove();
					$(".img_len").find("i").text($(".imgAll li").length);
				});
				var _deid = $(this).parent().attr('data-delId');
				for(var n=0;n<_dataArr.length;n++){
					if(_dataArr[n].delId == _deid){
						_dataArr.splice(n,1);
					}
				}
				_self.callback(_dataArr);				
			});
		};
		var _Imgpreview = $(this.b).find('img');
		for(var k=0;k<_Imgpreview.length; k++){
			$(_Imgpreview[k]).off().on('click',function(){
				console.log($(this).attr('src'))
			})
		}
	}
 	win.ImgUploadeFiles = ImgUploadeFiles;
})(window);