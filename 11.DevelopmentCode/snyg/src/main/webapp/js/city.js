/**
 * Created by yf-chensb on 2016/12/18.
 */
/**
 * 定义City对象
 * param:objName必填，用于标记哪个city
 */
function City(objName){
    City.prototype.name = objName;
    City.prototype.selectedCitySet = new Array();
    City.prototype.cityLevelNameArray = new Array(); //城市级别对应名称
}
/**
 * 初始化City
 * outDoom,页面显示的外对象
 * initCityId,默认显示的城市Id(非必填)
 */
City.prototype.init = function(outDoom,initCityId)
{
    if(typeof(outDoom) == "undefined" )
    {
        throw new error("未设置存放位置");
    }
    //设置存放位置
    this.outDoom = outDoom;
    //设置默认最小级别
    this.minCityLevel = 1;
    //设置默认最大级别
    this.maxCityLevel = Number.MAX_VALUE;
    this.initCityId(initCityId);

    var levelNameArray = new Array();
    var foreigh = new Object();
    foreigh.level = 0;
    foreigh.levelName = "f_foreigh";
    levelNameArray.push(foreigh);
    var province = new Object();
    province.level = 1;
    province.levelName = "f_province";
    levelNameArray.push(province);
    var city = new Object();
    city.level = 2;
    city.levelName = "f_city";
    levelNameArray.push(city);
    var xian = new Object();
    xian.level = 3;
    xian.levelName = "f_xian";
    levelNameArray.push(xian);
    this.initCityLevelName(levelNameArray);
}

/**
 * 初始化levelName
 * levelNameArray 级别名称
 */
City.prototype.initCityLevelName = function(levelNameArray)
{
    this.cityLevelNameArray = levelNameArray;
}

/**
 * 初始化默认选中城市
 */
City.prototype.initCityId = function(initCityId)
{
    this.selectedCitySet = new Array();
    if(typeof(initCityId) != "undefined" && initCityId!= null && initCityId != '')
    {
        this.selectedCitySet.push("");
        do{
            var params = "&cityId=" + initCityId;
            var citys = this.getCityList(params);
            if(citys.length != 1)
            {
                throw new Error("未设置存放位置");
            }
            if(parseInt(citys[0].cityLevel) >= this.minCityLevel)
            {
                initCityId = citys[0].pcityId;
                this.selectedCitySet.splice(0,0,citys[0].cityId);
                if(parseInt(citys[0].cityLevel) == this.minCityLevel)
                {
                    break;
                }
            }else {
                break;
            }
        }while(true)
    }else
    {
        this.selectedCitySet.push("");//如果初始化id，则默认选中一个'请选择'
    }
}

/**
 * 设置和获取最大允许的城市级别
 */
City.prototype.maxCityLevel = function(maxCityLevel)
{
    if(typeof(maxCityLevel) == "undefined" || maxCityLevel == null)
    {
        return this.prototype.maxCityLevel;
    }else
    {
        return this.prototype.maxCityLevel = maxCityLevel;
    }
}

/**
 * 设置城市变更以后的动作
 */
City.prototype.bindChangeSelectCityEvent = function () {}

/**
 * 设置和获取最小城市级别
 */
City.prototype.minCityLevel = function(minCityLevel)
{
    if(typeof(minCityLevel) == "undefined" || minCityLevel == null)
    {
        return this.prototype.minCityLevel;
    }else
    {
        return this.prototype.minCityLevel = minCityLevel;
    }
}

/**
 * 获取选中城市id数组
 */
City.prototype.getSelectedCitySet = function()
{
    return this.selectedCitySet;
}

/**
 * 获取选中最大城市级别城市级别
 */
City.prototype.maxLevelSelectedCityLevel = function () {
    var maxLevelSelectedCityLevel = "";
    if(this.selectedCitySet.length==1)
    {
        maxLevelSelectedCityLevel =  this.minCityLevel;
    }else
    {
        if(this.selectedCitySet[this.selectedCitySet.length-1] == "")
        {
            maxLevelSelectedCityLevel =   this.minCityLevel +  this.selectedCitySet.length-2;
        }else {
            maxLevelSelectedCityLevel =  this.minCityLevel +  this.selectedCitySet.length-1;
        }
    }
    return maxLevelSelectedCityLevel;
}

/**
 * 获取选中最大城市级别城市级别名称
 */
City.prototype.maxLevelSelectedCityLevelName = function () {
    var maxLevelSelectedCityLevel = this.maxLevelSelectedCityLevel();
    var maxLevelSelectedCityLevelName = "";
    for(var i=0;i<this.cityLevelNameArray.length;i++)
    {
        if(maxLevelSelectedCityLevel == this.cityLevelNameArray[i].level)
        {
            maxLevelSelectedCityLevelName = this.cityLevelNameArray[i].levelName;
            break;
        }
    }
    return maxLevelSelectedCityLevelName;
}

/**
 * 获取选中最大城市级别城市id
 */
City.prototype.maxLevelSelectedCityId = function () {
    var maxLevelSelectedCityId = "";
    if(this.selectedCitySet.length==1)
    {
        maxLevelSelectedCityId =  this.selectedCitySet[0];
    }else
    {
        if(this.selectedCitySet[this.selectedCitySet.length-1] == "")
        {
            maxLevelSelectedCityId =  this.selectedCitySet[this.selectedCitySet.length-2];
        }else {
            maxLevelSelectedCityId =  this.selectedCitySet[this.selectedCitySet.length-1];
        }
    }
    return maxLevelSelectedCityId;
}

/**
 * 获取选中最大城市级别城市名字
 */
City.prototype.maxLevelSelectedCityName = function () {
    var maxLevelSelectedCityLevel = this.maxLevelSelectedCityLevel();

    var maxLevelSelectedCityName = "";
    $(this.outDoom).find("select").each(function (index,dom) { //删除大于的select
        if(typeof($(dom).attr("cityLevel")) != "undefined" && parseInt($(dom).attr("cityLevel"))== maxLevelSelectedCityLevel)
        {
            if('----请选择----' != $(dom).find("option:selected").text())
            {
                maxLevelSelectedCityName = $(dom).find("option:selected").text();
            }
        }
    });
    return maxLevelSelectedCityName;
}
/**
 * 根据参数获取城市列表
 */
City.prototype.getCityList = function(params){
    var result = new Array();
    $.ajax({
        type: "POST",
        dataType : "json",
        async: false,
        url: "city?method=ajaxList"+ params ,
        success: function (data) {
            result =  data;
        }
    });
    return result;
}
/**
 * 扩展城市级别
 * cityLevel 扩展的城市级别
 * pcityId 父城市级别（为null或者undefined是为''）
 * cityId 当前城市级别选中的城市 （为null或者undefined是为''）
 */
City.prototype.appendLevel = function(cityLevel,pcityId,cityId,foreighParam)
{
    var params = "&cityLevel="+cityLevel;
    if(typeof(pcityId) != "undefined" && pcityId != null)
    {
        params = params + "&pcityId="+pcityId;
    }
    if(typeof(foreighParam) != "undefined" && foreighParam != null)
    {
        params = params + "&foreigh=" + foreighParam;
    }else
    {
        params = params + "&foreigh=0";
    }
    var citys = this.getCityList(params);
    if(citys.length>0)
    {
        var selectHtml = '<select onchange="'+ this.name+'.changeSelectCity(this)" class="data-searchtxt-select" cityLevel="' + cityLevel + '">'
            +'<option value="">----请选择----</option>';
        if(typeof(cityId) == "undefined" || cityId == null)
        {
            cityId = "";
        }
        for(var i=0;i<citys.length;i++)
        {
            selectHtml = selectHtml + '<option value="' + citys[i].cityId + '" '+ (citys[i].cityId == cityId?'selected="selected"':'')+'>'+citys[i].cityName+'</option>';
        }
        selectHtml = selectHtml + '</select>';
        $(this.outDoom).append(selectHtml);
    }
}

City.prototype.changeSelectCity = function (selectDom) {
    var selectCityLevel = parseInt($(selectDom).attr("cityLevel")); //选中的级别
    var selectCityId = $(selectDom).val();
    var selectCityIndex = selectCityLevel - this.minCityLevel;
    var delLength = this.selectedCitySet.length -selectCityIndex;
    this.selectedCitySet.splice(selectCityIndex,delLength,selectCityId)//删除大于等于当前级别，并插入当前级别
    $(selectDom).parent().find("select").each(function (index,dom) { //删除大于的select
        if(typeof($(dom).attr("cityLevel")) != "undefined" && parseInt($(dom).attr("cityLevel"))>selectCityLevel)
        {
            $(dom).remove();
        }
    })
    if(selectCityId != '')
    {
        this.selectedCitySet.push("");
        this.appendLevel(selectCityLevel+1,selectCityId,"");
    }
    this.bindChangeSelectCityEvent();
}

City.prototype.show = function(foreighParam)
{
    var html = "";
    for(var i=0;i<this.selectedCitySet.length;i++)
    {
        var pcityId = i>0?this.selectedCitySet[i-1]:null;
        this.appendLevel(this.minCityLevel+i,pcityId,this.selectedCitySet[i],foreighParam);
    }
}