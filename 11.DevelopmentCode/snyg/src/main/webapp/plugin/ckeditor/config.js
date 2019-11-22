/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	config.language = 'zh-cn'; // 配置语言
	// config.uiColor = '#FFF'; // 背景颜色
	config.width = '650px'; // 宽度
	config.height = '200px'; // 高度
	// config.skin = 'office2003';//界面v2,kama,office2003
	config.toolbar = 'Define';// 工具栏风格Full,Basic
	config.toolbar_Define = [
			[ 'Source', '-', 'NewPage', 'Preview', '-', 'Templates' ],
			[ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-',
					'Print', 'SpellChecker', 'Scayt' ],
			[ 'Undo', 'Redo', '-', 'Find', 'Replace', '-', 'SelectAll',
					'RemoveFormat' ],[ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ],
			[ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select',
					'Button', 'ImageButton', 'HiddenField' ],
		
			
			[ 'Bold', 'Italic', 'Underline', 'Strike', '-', 'Subscript',
					'Superscript' ],
			[ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent',
					'Blockquote', 'CreateDiv' ],
				
			[ 'Link', 'Unlink', 'Anchor' ],	'/',
			[ 'Multiimg', /*'Image',*/ 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar',
					'PageBreak' ], 
			[ 'Styles', 'Format', 'Font', 'FontSize' ],
			[ 'TextColor', 'BGColor' ],
			[ 'Maximize', 'ShowBlocks', '-', 'About' ],	[ 'BidiLtr', 'BidiRtl' ]

	];
	// config.filebrowserBrowseUrl = "ckfinder/ckfinder.html";
	// config.filebrowserImageBrowseUrl = "ckfinder/ckfinder.html?Type=Images";
	// config.filebrowserFlashBrowseUrl = "ckfinder/ckfinder.html?Type=Flash";
	// config.filebrowserUploadUrl =
	// "ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Files";
	//config.filebrowserImageUploadUrl = "common/ckeditorUpload.do?type=Images";
	// config.filebrowserFlashUploadUrl =
	// "ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Flash";
	
	//设置图像选项里  隐藏高级和链接按钮
	config.removeDialogTabs = 'image:advanced;image:Link';
	
	config.extraPlugins="multiimg"; //注册自定义按钮
};
