/**
 * 如果String中没有trim和relpaceAll方法，则重写此方法
 */
if (!String.prototype.trim || !String.prototype.replaceAll) {
	$.extend(String.prototype, {
		trim : function() {
			return this.replace(/(^\s*)|(\s*$)/g, "");
		},
		replaceAll : function(s1, s2) {
			return this.replace(new RegExp(s1, "gm"), s2);
		}
	});
}

/**
 * 查询列表中未找到记录时的提示消息方法
 */
function showListIsNullMsg() {
	$("#ListIsNullMsg").text("抱歉,没有找到符合检索条件的记录。");
}

// 删除信息函数
function deleteId() {
	var strArray = new Array();
	$("input[name=delId]:checkbox:checked").each(function() {
		var flag = $(this).attr("checked");

		if (flag) {
			strArray.push($(this).val());
		}
	});
	if (strArray == "") {
		art.dialog.alert("请至少选中一项");
		// alert("请至少选中一项");
		return;
	} else {// if (confirm("确认删除吗？")) {
		// strstr = str.substring(0, str.length - 1);
		// window.location.href = "batchDelMember.action?checkedIds=" +
		// strArray;
		// document.getElementById("checkedIds").value = strArray;
		art.dialog.confirm('确认要删除所选中记录吗？', function() {
			$("#checkedIds").val(strArray);
			document.forms[1].submit();
		}, function() {
			// art.dialog.tips('取消当前操作');
		});
		// $("#checkedIds").val(strArray);
		// document.forms[1].submit();
	}
}

/**
 * artDialog提示控件 跳转url
 * 
 * @param message
 * @param url
 */
function artConfirmUrl(message, url) {
	if (message == null) {
		message = '确定要删除这条记录吗？';
	}
	art.dialog.confirm(message, function() {
		window.location.href = url;
		// art.dialog.close();
	}, function() {
		// art.dialog.tips('取消当前操作');
	});
}

/**
 * artDialog提示控件 执行fun
 * 
 * @param message
 * @param myfun
 */
function artConfirmFun(message, myfun) {
	if (message == null) {
		message = '确定要删除这条记录吗？';
	}
	art.dialog.confirm(message, function() {
		myfun();
		// art.dialog.close();
	}, function() {
		// art.dialog.tips('取消当前操作');
	});
}


/**
 * 获取选中多选框的值 多个值以逗号隔开
 * @param checkname  多选框name
 */
function getCheckedValues(checkname){
	var checkstr="";
	$("input[name="+checkname+"]:checked").each(function(i) {
		if(i==0){
			checkstr+=$(this).val();
		}else{
			checkstr+=","+$(this).val();
		}
		
	});
	return checkstr;
}


/**
 * 初始化全选checkbox
 * @param parentcheck  父多选框 id
 * @param soncheck   子多选框 name
 */
function initCheckBox(parentcheck,soncheck){
	$("#"+parentcheck).click(function() {
		var flag = $(this).attr("checked");
		$("input[name="+soncheck+"]:checkbox").each(function() {
			if (this.disabled != true) {
				if (flag == null) {
					$(this).attr("checked", false);
				} else {
					$(this).attr("checked", true);
				}
			}
		});
	});

	$("input[name="+soncheck+"]:checkbox").each(function(i) {
		$(this).click(function() {
			
		    if($("input[name="+soncheck+"]:checked").length == $("input[name="+soncheck+"]:checkbox").length ){
		    	$("#"+parentcheck).attr("checked", true);	    	
		    }else{	
		    	$("#"+parentcheck).removeAttr("checked");
		    }
		})
	});
}

/**
 * 排序初始方法
 */
$(function() {

	var sortfield = document.getElementById("entityPage.sortField");
	var sortfieldval;
	if (sortfield != null) {
		sortfieldval = sortfield.value;
	}
	if (sortfield == null || sortfield == '') {
		return;
	}
	if ($("#entityPage\\.sortOrder").val() == null || $("#entityPage\\.sortOrder").val() == '') {
		return;
	}
	if ($("#entityPage\\.sortOrder").val() == "ASC") {
		$(document.getElementById(sortfieldval)).addClass("ico_pxucs");
	} else {
		$(document.getElementById(sortfieldval)).addClass("ico_pxdcs");
	}

})

/**
 * 排序方法
 * @param field  排序参数
 */
function sort(field) {
	if ($("#entityPage\\.sortField").val() == field) {
		if ($("#entityPage\\.sortOrder").val() == "ASC") {
			$("#entityPage\\.sortOrder").val("DESC");
		} else {
			$("#entityPage\\.sortOrder").val("ASC");
		}
	} else {
		$("entityPage\\.currentPage").val(1);
		$("#entityPage\\.sortField").val(field);
		$("#entityPage\\.sortOrder").val("DESC");
	}
	onSubmit();
}

/**
 * 提交页面第一个表单
 */
function onSubmit(){
	document.forms[0].submit();
}

/**
 * 自动补齐共通方法 使用方法： 设置atc属性为补齐action或do方法
 */
$(function() {
	$("input[atc]").each(function() {
		var inputid = "#" + $(this).attr("id");
		var inputatc = $(this).attr("atc");
		$(inputid).autocomplete({
			minLength : 0,
			source : function(request, response) {
				$.post(inputatc, request, function(data) {
					response(eval("(" + data + ")"));
				});
			}
		});
	})
})

/**
 * 设置第一个控件的焦点，需要增加一个firstfocus的class
 */
$(function() {
	window.onload = function() {
		$(".firstfocus").focus();
	};
})

/**
 * 点击delete键，清空文本框信息
 */
$(function() {
	$("input[type='text'][readonly!='readonly']").each(function(i) {
		$(this).keydown(function(event) {
			event = event || window.event;
			if (event.keyCode == 46) {
				$(this).val("");
				$(this).focus();
			}
		});
	});

});

/**
 * 使用可输入可选择下拉控件时，如需再使用select的onChange事件，则需要在各自页面重写以下方法代替
 * 
 * @param value
 *            选中的option的value值
 * @param txt
 *            选中的option的text值
 * @param id
 *            选中的option的id值(可区分同一页面使用多个此控件方法时判断使用)
 */
function comboxChange(value, txt, id) {

}

/**
 * 可输入可选择下拉控件 初始方法 使用事例： $(function(){ initCombox(); $("#Id").combobox();
 * //Id为select控件id })
 */
function initCombox() {
	var n = 0;
	$.widget( "custom.combobox", {
	      _create: function() {
	        this.wrapper = $( "<span>" )
	          .insertAfter( this.element );
	 
	        this.element.hide();
	        this._createAutocomplete();
	        this._createShowAllButton();
	      },
	 
	      _createAutocomplete: function() {
	    	  n++;
	          var selected = this.element.children( ":selected" ),
	          //值为空时也显示下拉项
	          //value = $.trim(selected.val()) ? $.trim(selected.text()) : "";
	          value =  $.trim(selected.text());
	        this.input = $("<input>")
	          .appendTo(this.wrapper)
	          .val(value)
	          .attr("onclick","selectComboxContext(this)")
	          .attr("title","")
	          .attr("id", n) //添加id值 解决一个页面中使用多个控件问题
	          .css("margin-right","0")
	          .addClass("validate[required] data-searchtxt")
	          .autocomplete({
	            delay: 0,
	            minLength: 0,
	            source: $.proxy( this, "_source" )
	          })
	          .tooltip({
	            tooltipClass: "ui-state-highlight"
	          });
	 
	        this._on( this.input, {
	          autocompleteselect: function( event, ui ) {
	        	// 调用自定义change方法
	        	comboxChange(ui.item.option.value,ui.item.option.text,ui.item.option.id); 
	        	
	            ui.item.option.selected = true;
	            this._trigger( "select", event, {
	              item: ui.item.option
	            });
	          },
	          autocompletechange: "_removeIfInvalid"
	        });
	      },
	 
	      _createShowAllButton: function() {
	        var input = this.input,
	          wasOpen = false;
	        $( "<a>" )
	          .attr( "tabIndex", -1 )
	          //点击下拉箭头显示的提示语
	          //.attr( "title", "Show All Items" )
	          .addClass("as1")//下拉箭头使用自己的class
	          .attr("title","")
	          .tooltip()
	          .appendTo( this.wrapper )
	          .button({
	            icons: {
	              primary: "ui-icon-triangle-1-s"
	            },
	            text: false
	          })
	          .removeClass( "ui-corner-all" )
	          .addClass( "custom-combobox-toggle ui-corner-right" )
	          .mousedown(function() {
	            wasOpen = input.autocomplete( "widget" ).is( ":visible" );
	          })
	          .click(function() {
	            input.focus();
	            // Close if already visible
	            if ( wasOpen ) {
	              return;
	            }
	            // Pass empty string as value to search for, displaying all results
	            input.autocomplete( "search", "" );
	          });
	      },
	 
	      _source: function( request, response ) {
	        var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
	        response( this.element.children( "option" ).map(function() {
	          //过滤掉选项值的空格
	          var text =$.trim($(this).text());
	          //去掉下拉项中值为空不显示的判断  this.value
	          if ((!request.term || matcher.test(text) ) )
	            return {
	              label: text,
	              value: text,
	              option: this
	            };
	        }) );
	        
	        //设置下拉选项显示区域的高度及宽度
	        $("ul[class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']").each(function(i) {
	        	$(this).height("auto");
				$(this).css("overflow","auto");
				if ($(this).height() > 300) {
					$(this).height(300).css("overflow-y","scroll");
					$(this).height(300).css("overflow-x","hidden");
				}else{
					$(this).css("overflow","hidden");
				}
				$(this).width("auto");			
				//$(this).width($("#"+i).width());
			});
	      },
	 
	      _removeIfInvalid: function( event, ui ) {
	        // Selected an item, nothing to do
	        if ( ui.item ) {
	          return;
	        }
	        // Search for a match (case-insensitive)
	        var value = this.input.val(),
	          valueLowerCase = value.toLowerCase(),
	          valid = false;
	        this.element.children( "option" ).each(function() {
	          if ( $( this ).text().toLowerCase() === valueLowerCase ) {
	            this.selected = valid = true;
	            return false;
	          }
	        });
	 
	        // Found a match, nothing to do
	        if ( valid ) {
	          return;
	        }
	 
	        // Remove invalid value
	        this.input.val("")
            //输入的内容未在下拉列表中找到时的提示语
            //.attr("title",value + " didn't match any item" ) 
	          .attr("title","")
	          .tooltip("open");
	        
	        this.element.val( "" );
	        this._delay(function() {
	          this.input.tooltip( "close" ).attr( "title", "" );
	        }, 2500 );
	        this.input.autocomplete( "instance" ).term = "";
	      },
	 
	      _destroy: function() {
	        this.wrapper.remove();
	        this.element.show();
	      },
	  
	    });
	
}

/**
 * 可以直接输入值，失去焦点也不清空
 */
function initCombox2() {
	var n = 0;
	$.widget( "custom.combobox", {
	      _create: function() {
	        this.wrapper = $( "<span>" )
	          .insertAfter( this.element );
	 
	        this.element.hide();
	        this._createAutocomplete();
	        this._createShowAllButton();
	      },
	 
	      _createAutocomplete: function() {
	    	  n++;
	          var selected = this.element.children( ":selected" ),
	          //值为空时也显示下拉项
	          //value = $.trim(selected.val()) ? $.trim(selected.text()) : "";
	          value =  $.trim(selected.text());
	        this.input = $("<input>")
	          .appendTo(this.wrapper)
	          .val(value)
	          .attr("title","")
	          .attr("id", n) //添加id值 解决一个页面中使用多个控件问题
	          .css("margin-right","0")
	          .addClass("validate[required] data-searchtxt")
	          .autocomplete({
	            delay: 0,
	            minLength: 0,
	            source: $.proxy( this, "_source" )
	          })
	          .tooltip({
	            tooltipClass: "ui-state-highlight"
	          });
	 
	        this._on( this.input, {
	          autocompleteselect: function( event, ui ) {
	        	// 调用自定义change方法
	        	comboxChange(ui.item.option.value,ui.item.option.text,ui.item.option.id); 
	        	
	            ui.item.option.selected = true;
	            this._trigger( "select", event, {
	              item: ui.item.option
	            });
	          },
	          autocompletechange: "_removeIfInvalid"
	        });
	      },
	 
	      _createShowAllButton: function() {
	        var input = this.input,
	          wasOpen = false;
	        $( "<a>" )
	          .attr( "tabIndex", -1 )
	          //点击下拉箭头显示的提示语
	          //.attr( "title", "Show All Items" )
	          .addClass("as1")//下拉箭头使用自己的class
	          .attr("title","")
	          .tooltip()
	          .appendTo( this.wrapper )
	          .button({
	            icons: {
	              primary: "ui-icon-triangle-1-s"
	            },
	            text: false
	          })
	          .removeClass( "ui-corner-all" )
	          .addClass( "custom-combobox-toggle ui-corner-right" )
	          .mousedown(function() {
	            wasOpen = input.autocomplete( "widget" ).is( ":visible" );
	          })
	          .click(function() {
	            input.focus();
	            // Close if already visible
	            if ( wasOpen ) {
	              return;
	            }
	            // Pass empty string as value to search for, displaying all results
	            input.autocomplete( "search", "" );
	          });
	      },
	 
	      _source: function( request, response ) {
	        var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
	        response( this.element.children( "option" ).map(function() {
	          //过滤掉选项值的空格
	          var text =$.trim($(this).text());
	          //去掉下拉项中值为空不显示的判断  this.value
	          if ((!request.term || matcher.test(text) ) )
	            return {
	              label: text,
	              value: text,
	              option: this
	            };
	        }) );
	        
	        //设置下拉选项显示区域的高度及宽度
	        $("ul[class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']").each(function(i) {
	        	$(this).height("auto");
				$(this).css("overflow","auto");
				if ($(this).height() > 300) {
					$(this).height(300).css("overflow-y","scroll");
					$(this).height(300).css("overflow-x","hidden");
				}else{
					$(this).css("overflow","hidden");
				}
				$(this).width("auto");			
				//$(this).width($("#"+i).width());
			});
	      },
	 
	      _removeIfInvalid: function( event, ui ) {
	        // Selected an item, nothing to do
	        if ( ui.item ) {
	          return;
	        }
	        // Search for a match (case-insensitive)
	        var value = this.input.val(),
	          valueLowerCase = value.toLowerCase(),
	          valid = false;
	        this.element.children( "option" ).each(function() {
	          if ( $( this ).text().toLowerCase() === valueLowerCase ) {
	            this.selected = valid = true;
	            return false;
	          }
	        });
	 
	        // Found a match, nothing to do
	        if ( valid ) {
	          return;
	        }
	 
	        // Remove invalid value
	        //this.input.val("")
            //输入的内容未在下拉列表中找到时的提示语
            //.attr("title",value + " didn't match any item" ) 
	        //  .attr("title","")
	        //  .tooltip("open");
	        
	        this.element.val( "" );
	        this._delay(function() {
	          this.input.tooltip( "close" ).attr( "title", "" );
	        }, 2500 );
	        this.input.autocomplete( "instance" ).term = "";
	      },
	 
	      _destroy: function() {
	        this.wrapper.remove();
	        this.element.show();
	      },
	  
	    });
}

/**
 * 可输入可选择下拉控件 点击选中当前文本内容
 */
function selectComboxContext(obj)
{
	$(obj).select();
	if($(obj).val() == "----请选择----") {
		$(obj).val("");
	}
}


/**
 * JS延迟提交代码 
 * 解决重复提交问题
 * 调用示例：  
 * delayTillLastDo('id', function(){//注意 id 是唯一的
 *    //TODO
 * }, 300);
**/
var timerObj = {};
function delayTillLastDo(id, fn, wait) {
    if (timerObj[id]) {
        window.clearTimeout(timerObj[id]);
        delete timerObj[id];
    }

    return timerObj[id] = window.setTimeout(function() {
        fn();
        delete timerObj[id];
    }, wait);
}

/**
 * 身份证校验
 * @param code
 * @returns {Boolean}
 */
function identityCodeValid(code) { 
    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
    var tip = "";
    var pass= true;

    if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
        tip = "身份证号格式错误";
        pass = false;
    }

   else if(!city[code.substr(0,2)]){
        tip = "地址编码错误";
        pass = false;
    }
    else{
        //18位身份证需要验证最后一位校验位
        if(code.length == 18){
            code = code.split('');
            //∑(ai×Wi)(mod 11)
            //加权因子
            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
            //校验位
            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
            var sum = 0;
            var ai = 0;
            var wi = 0;
            for (var i = 0; i < 17; i++)
            {
                ai = code[i];
                wi = factor[i];
                sum += ai * wi;
            }
            var last = parity[sum % 11];
            if(parity[sum % 11] != code[17]){
                tip = "校验位错误";
                pass =false;
            }
        }
    }
   // if(!pass) alert(tip);
    return pass;
}

/**
 * artDialog右下角弹出层
 */
artDialog.notice = function (options) {
	var opt = options || {},
		api, aConfig, hide, wrap, top,
		duration = 800;
		
	var config = {
		id: 'Notice',
		left: '98%',
		top: '100%',
		fixed: true,
		drag: false,
		resize: false,
		follow: null,
		lock: false,
		init: function(here){
			api = this;
			aConfig = api.config;
			wrap = api.DOM.wrap;
			top = parseInt(wrap[0].style.top);
			hide = top + wrap[0].offsetHeight;
			
			wrap.css('top', hide + 'px')
				.animate({top: top + 'px'}, duration, function () {
					opt.init && opt.init.call(api, here);
				});
		},
		close: function(here){
			wrap.animate({top: hide + 'px'}, duration, function () {
				opt.close && opt.close.call(this, here);
				aConfig.close = $.noop;
				api.close();
			});
			
			return false;
		}
	};	
	
	for (var i in opt) {
		if (config[i] === undefined) config[i] = opt[i];
	};
	
	return artDialog(config);
};


/* js算术运算修正版   */
function $add(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), ($mul(a, e) + $mul(b, e)) / e;
}
 
function $sub(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), ($mul(a, e) - $mul(b, e)) / e;
}
 
function $mul(a, b) {
    var c = 0,
        d = a.toString(),
        e = b.toString();
    try {
        c += d.split(".")[1].length;
    } catch (f) {}
    try {
        c += e.split(".")[1].length;
    } catch (f) {}
    return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
}
 
function $div(a, b) {
    var c, d, e = 0,
        f = 0;
    try {
        e = a.toString().split(".")[1].length;
    } catch (g) {}
    try {
        f = b.toString().split(".")[1].length;
    } catch (g) {}
    return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), $mul(c / d, Math.pow(10, f - e));
}

//选中其中一
function selectTr(table)
{
    var oddColor = "#ffffff"; //奇数颜色
    var evenColor = "#f6f6f6";//偶数行背景
    var mouseOverColor = "#e7e7e7";//鼠标经过背景
    var mouseClickColor = "#e7e7e7"; //点击后背景
    $("#"+table).find("tr").each(function (index,trDoom) {
        if(index >0)
        {
            //默认初始未选中
            $(this).attr("hashCheck","no");
            if(index %2 == 0) //偶数行
            {
                $(trDoom).css("background-color",evenColor);
            }else { //奇数行
                $(trDoom).css("background-color",oddColor);
            }
            $(trDoom).mouseleave(function () {
                if($(this).attr("hashCheck") == "no")
                {
                    if($("#"+table).find("tr").index($(this))%2 == 0)
                    {
                        $(this).css("background-color",evenColor);
                    }else {
                        $(this).css("background-color",oddColor);
                    }
                }
            });
            $(trDoom).click(function () {
                //还原已经选中的tr
                var checkEdTr = $("tr[hashCheck='yes']");
                $(checkEdTr).attr("hashCheck","no");
                $(checkEdTr).mouseleave();

                //标识当前tr选中
                $(this).css("background-color",mouseClickColor);
                $(this).attr("hashCheck","yes");
            });
        }
    });
}


//等待页面
function waitingDialog(msg){
	 
	 art.dialog.through({
         lock: true,
         content: msg,
         cancel: false
     });	 
}

//解决弹框依赖于CKEDITOR窗口
CKEDITOR.on('dialogDefinition', function (e) {
	var dialog = e.data.definition.dialog;
	var name = e.editor.name;
	dialog.on('show', function (e) {	
		var top = $("#cke_" + name).offset().top;
		$(".cke_dialog").css("top", top + "px");
	}); 
});

// 全选
$(function(){
	$("#allcheck").click(function() {
		var flag = $(this).attr("checked");
		$("input[name=delId]:checkbox").each( function() {
			if (this.disabled != true) {
				if (flag == null) {
					$(this).attr("checked", false);
				} else {
					$(this).attr("checked", true);
				}
			}
		});
	});
});


/*******图片上传开始*******/
function addRsPicCom(rsType, picId, contextPath,tableName) {
	/*
	addItemDialog = art.dialog.open('rspic.do?method=toAdd&rsType='+rsType+'&picId='+picId,{
		lock: true,
	    	resize: false,
	  	    width: 625,
	        height: 460,
	        close : function(){
	        	picId = art.dialog.data('picId');
	        	var picFileName = art.dialog.data('picFileName');
	        	var picTitle = art.dialog.data('picTitle');
	        	
	        	art.dialog.data('picId', null);
	    		art.dialog.data('picFileName', null);
	    		
        	 if(picId != null) {
        		 saveItemCom(null, picId, picFileName, picTitle,contextPath,tableName);
        	 }
	        }
	});
	*/
	var content = 'rspic.do?method=toAdd&rsType='+rsType+'&picId='+picId;
	parent.layer.open({
		type : 2,
		title : '上传图片',
		area : [ '725px', '460px' ],
		fix : true,
		content :content,
		end: function(){
			var picId = picId = art.dialog.data('picId');
			if(picId!=null &&picId!=''){
	        	var picFileName = art.dialog.data('picFileName');
	        	var picTitle = art.dialog.data('picTitle');
				saveItemCom(null, picId, picFileName, picTitle,contextPath,tableName);
			}
		}
	});
}
	
function saveItemCom(obj, picId, picFileName, picTitle, contextPath, tableName)
{
	if(null == obj)
	{
		var table = document.getElementById(tableName);
		var tr = table.insertRow(table.rows.length);
		insertOrUpdateTrCom(tr, picId, picFileName, picTitle,contextPath,tableName);
	}else
	{
		var tr = obj.parentNode.parentNode;
		tr.innerHTML = null;
		insertOrUpdateTrCom(tr, picId, picFileName, picTitle,contextPath,tableName);
	}
	reSetIndexCom(tableName);
}

function insertOrUpdateTrCom(tr, picId,picFileName,picTitle,contextPath, tableName)
{
	var cel = tr.insertCell(-1);
	cel.innerHTML = "";
	cel.width="5%";
	
	cel = tr.insertCell(-1);
	cel.innerHTML = '<img src="'+contextPath+'/upload/wxpic/'+ picFileName +'" width="110" height="70" border="0" style="margin:5px 15px 0px 0px;">';
	
	cel.width="30%";
	
	cel = tr.insertCell(-1);
	cel.innerHTML = picTitle+'<input type="hidden" name="picIds" value="'+picId+'"/>';
	cel.width="35%";
	
	
	cel = tr.insertCell(-1);
	cel.innerHTML = '<a href="javascript:void(0);" onclick="moveUpCom(this,\''+tableName+'\')" class="ico_btn">上移</a>&nbsp;'
		+ '<a href="javascript:void(0);" onclick="moveDownCom(this,\''+tableName+'\')" class="ico_btn">下移</a>&nbsp;' 
		+ '<a href="javascript:void(0);" onclick="upItemCom(this,\''+picId+'\',\''+contextPath+'\',\''+tableName+'\')" class="ico_btn">编辑</a>&nbsp;' 
		+ '<a href="javascript:void(0);" onclick="deleteItemCom(\''+picId+'\',this,\''+tableName+'\')" class="ico_btn">删除</a>';
	cel.width="20%";
}

function reSetIndexCom(tableName)
{
	var table = document.getElementById(tableName);
	var len=table.rows.length;
	for (i=1;i<len;i++) 
	{  
	    table.rows[i].cells[0].innerHTML=i;
	}
}

function upItemCom(obj, picId, contextPath, tableName,rsType)
{
	
	/*var rsType = "0";//资源类型
	addItemDialog = art.dialog.open('rspic.do?method=toAdd&rsType='+rsType+'&picId='+picId,{
		lock: true,
	    	resize: false,
	  	    width: 625,
	        height: 460,
	        close : function(){
	        	picId = art.dialog.data('picId');
	        	var picFileName = art.dialog.data('picFileName');
	        	var picTitle = art.dialog.data('picTitle');
	        	
	        	art.dialog.data('picId', null);
	    		art.dialog.data('picFileName', null);
	    		
        	 if(picId != null) {
        		 saveItemCom(obj, picId, picFileName, picTitle, contextPath, tableName);
        	 }
    	 }
	});*/
	
	var content = 'rspic.do?method=toAdd&rsType='+rsType+'&picId='+picId;
	parent.layer.open({
		type : 2,
		title : '上传图片',
		area : [ '725px', '460px' ],
		fix : true,
		content :content,
		end: function(){
			var picId = picId = art.dialog.data('picId');
			if(picId!=null &&picId!=''){
	        	var picFileName = art.dialog.data('picFileName');
	        	var picTitle = art.dialog.data('picTitle');
	        	art.dialog.data('picId', null);
	    		art.dialog.data('picFileName', null);
	    		
	        	saveItemCom(obj, picId, picFileName, picTitle, contextPath, tableName);
			}
		}
	});
}

function deleteItemCom(picId,obj,tableName)
{
	parent.layer.confirm("确定要删除这条记录吗？", function() {
		var tr = obj.parentNode.parentNode;
		tr.parentNode.removeChild(tr);
		$.post('rspic.do?method=delete',{'picId':picId},function(data){
			reSetIndexCom(tableName);
			parent.layer.closeAll();
		});
	});
}

//使表格行上移，接收参数为链接对象 
function moveUpCom(_a,tableName)
{
	var _row = _a.parentNode.parentNode;
	var _par = _row.parentNode;
	var _trs = _par.getElementsByTagName('tr');
	var _pos = _row.rowIndex;
	if(_pos>1)
	{
		swapNodeCom(_row,_trs[_pos-1]);
	}
  	reSetIndexCom(tableName);
} 
	
//使表格行下移，接收参数为链接对象 
function moveDownCom(_a,tableName)
{ 
	var _row = _a.parentNode.parentNode;
	var _par = _row.parentNode;
	var _trs = _par.getElementsByTagName('tr');
	var _pos = _row.rowIndex;
	if(_pos<_trs.length-1){
		swapNodeCom(_row,_trs[_pos+1]);
	}
	
	reSetIndexCom(tableName);
} 

//定义通用的函数交换两个结点的位置 
function swapNodeCom(node1,node2)
{
	//获取父结点 
	var _parent=node1.parentNode; 
	//获取两个结点的相对位置 
	var _t1=node1.nextSibling; 
	var _t2=node2.nextSibling; 
	//将node2插入到原来node1的位置 
	if(_t1)_parent.insertBefore(node2,_t1); 
	else _parent.appendChild(node2); 
	//将node1插入到原来node2的位置 
	if(_t2)_parent.insertBefore(node1,_t2); 
	else _parent.appendChild(node1); 
} 
/*******图片上传结束*******/


//设置选中行背景色
function selectTr(obj){
	senfe("changecolor","","","#e5f1f4","#e5f1f4");
	$(obj).css("backgroundColor","#e5f1f4");
}

//senfe("表格名称","奇数行背景","偶数行背景","鼠标经过背景","点击后背景");
function senfe(o,a,b,c,d){
  var t=document.getElementById(o).getElementsByTagName("tr");
  for(var i=0;i<t.length;i++){
  	t[i].style.backgroundColor=(t[i].sectionRowIndex%2==0)?a:b;
  }
}

// 拼接文章链接
function getArticleHttpUrl(serviceCodeUrl, articleId) {
	return serviceCodeUrl + "/wx.do?method=showArticle&articleId=" + articleId;
}

// 金额验证（整数10位，小数最多2位；如果为空，验证通过）
function validateNum10Point2(str) {
	if (str != null && str != "") {
		var reg=/^[0-9]{1,10}(\.[0-9]{0,2})?$/;
		return reg.test(str)
	}
	
	return true;
}

//打开景区详情
function openScenicDetailCom(scenicId) {
	art.dialog.open('scenic.do?method=popScenicDetail&scenicId=' + scenicId,{
		lock: true,
    	resize: true,
  	    width: 850,
        height: 460
	});
}

// 打开产品详情
function openPdcDetailCom(pdcType, pdcId) {
	
	var url = "";
	
	// 0-线路1-门票2-酒店3-其他5-商品6-包装7-餐饮菜品20-B2B散客线路21-B2B团队线路
	if (pdcType == "1") {
		url = "ticket.do?method=popDetailTicket&pdcId=" + pdcId;
	} else if (pdcType == "5") {
		url = "commproduct.do?method=popCommProductDetail&pdcId=" + pdcId;
	}
	
	art.dialog.open(url,{
		lock: true,
    	resize: true,
  	    width: 850,
        height: 460
	});
}
/**
 * 超过四个查询条件的，展开和隐藏功能
 */
function showHideQuery() {

// 如果数量超过4个，显示点击展开更多
  if ($(".data-requry table tr td").length > 8) {
    $(".getMore").css({
      display: "block"
    });
    // 给展开更多空出位子
    $(".data-requry").css({
      "padding-bottom": "40px"
    })
  }
// 将所有的td存入数组中
  var tdArr = $(".data-requry table tr td");

// 判断是4的几倍
  var num = Math.floor(tdArr.length / 8) + 1;
  console.log(tdArr);

//清空表格
//$(".data-requry table").html("");
  for (var i = 0; i < num; i++) {
    // 一重循环追加tr
    $(".data-requry table").append("<tr></tr>");
    // 二重循环追加td
    for (var j = 0; j < 8; j++) {
      $(".data-requry table tr").eq(i).append(tdArr[(i * 8 + j)])
    }
  }

// 隐藏所有tr
  $('.data-requry table tr').each(function(i){
    $(this).css('display','none');//遍历tr
  });

// 一开始只能展示四个
  $(".data-requry table tr").eq(0).css('display','');

// 点击查看更多展示所有
  var flag = "more" // 定义一个展开的标识
  $(".getMore").on("click", function () {
    if (flag == "more") {
      //展示所有
      $('.data-requry table tr').each(function(i){
        $(this).css('display','');//遍历tr
      });
      flag = "less" // 改变标识为less，表示收起
      $(".getMore").text("点击收起 ▲")  // 改变展开盒子中的字
    } else {
      // 隐藏tr中所有td
      $('.data-requry table tr').each(function(i){
        $(this).css('display','none');//遍历tr
      });
      // 一开始只能展示四个
      $(".data-requry table tr").eq(0).css('display','');
      flag = "more" // 改变标识为more，表示展开
      $(".getMore").text("展开更多 ▼")
    }
	})
}




