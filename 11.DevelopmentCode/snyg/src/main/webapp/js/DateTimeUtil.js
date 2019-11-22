	
function DateTimeUtil()
{
	DateTimeUtil.prototype.sdf7 = "yyyy-MM";
	DateTimeUtil.prototype.sdf10 = "yyyy-MM-dd";
	DateTimeUtil.prototype.sdf16 = "yyyy-MM-dd hh:mm";
	DateTimeUtil.prototype.sdf14 = "yyyyMMddhhmmss";
	DateTimeUtil.prototype.sdf12 = "yyyyMMddhhmm";
	DateTimeUtil.prototype.sdf17 = "yyyyMMddhhmmssSSS";
	DateTimeUtil.prototype.sdf19 = "yyyy-MM-dd hh:mm:ss";
	DateTimeUtil.prototype.sdf23 = "yyyy-MM-dd hh:mm:ss:SSS";

	/**
	*获取Date
	*1.fmt = DateTimeUtil.sdf*
	*2.dateString = fmt格式的时间字符串
	*/
	DateTimeUtil.prototype.getDateTime = function getDateTime(fmt,dateString)
	{
		var yyyy = null,MM = null,dd = null,hh=null,mm=null,ss=null,SSS=null;
		if(fmt == this.sdf7) //"yyyy-MM-dd";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(5,7);
		}
		else if(fmt == this.sdf10) //"yyyy-MM-dd";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(5,7);
			dd = dateString.substring(8,10);
		}else if(fmt == this.sdf16) //sdf16 = "yyyy-MM-dd hh:mm";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(5,7);
			dd = dateString.substring(8,10);
			hh = dateString.substring(11,13);
			mm = dateString.substring(11,13);
		}else if(fmt == this.sdf14) //sdf14 = "yyyyMMddhhmmss";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(4,6);
			dd = dateString.substring(6,8);
			hh = dateString.substring(8,10);
			mm = dateString.substring(10,12);
			ss = dateString.substring(12,14);
		}else if(fmt == this.sdf12) //sdf12 = "yyyyMMddhhmm";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(4,6);
			dd = dateString.substring(6,8);
			hh = dateString.substring(8,10);
			mm = dateString.substring(10,12);
		}else if(fmt == this.sdf17) //sdf17 = "yyyyMMddhhmmssSSS";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(4,6);
			dd = dateString.substring(6,8);
			hh = dateString.substring(8,10);
			mm = dateString.substring(10,12);
			ss = dateString.substring(12,14);
			SSS = dateString.substring(14,17);
		}else if(fmt == this.sdf19) //sdf19 = "yyyy-MM-dd hh:mm:ss";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(5,7);
			dd = dateString.substring(8,10);
			hh = dateString.substring(11,13);
			mm = dateString.substring(14,16);
			ss = dateString.substring(17,19);
		}else if(fmt == this.sdf23) //sdf23 = "yyyy-MM-dd hh:mm:ss:SSS";
		{
			yyyy = dateString.substring(0,4);
			MM = dateString.substring(5,7);
			dd = dateString.substring(8,10);
			hh = dateString.substring(11,13);
			mm = dateString.substring(14,16);
			ss = dateString.substring(17,19);
			SSS = dateString.substring(20,23);
		}else
		{
			return null;
		}
		var date = new Date(yyyy);
		if(MM != null) date.setMonth(MM-1);
		if(dd != null) date.setDate(dd);
		if(hh != null) date.setHours(hh);
		if(mm != null) date.setMinutes(mm);
		if(ss != null) date.setSeconds(ss);
		if(SSS != null) date.setMilliseconds(SSS);
		return date
	}

	/**
	*获取格式化日期
	*1.fmt = DateTimeUtil.sdf*
	*2.date = Date对象
	*/
	DateTimeUtil.prototype.getStringDateTime = function getStringDateTime(fmt,date)
	{
		if(typeof(date) == 'object' && date instanceof Date)
		{
			return this.dateFtt(fmt,date);
		}else
		{
			return null;
		}
	}

	/**
	*更换时间格式
	*1.fromFmt = DateTimeUtil.sdf*或其他
	*2.toFmt = DateTimeUtil.sdf*或其他
	*2.date = stringDate与fromFmt相同的格式
	*/
	DateTimeUtil.prototype.parseDateTimeFormat = function parseDateTimeFormat(fromFmt,toFmt,stringDate)
	{
		var date = this.getDateTime(fromFmt,stringDate);
		return this.getStringDateTime(toFmt,date);
	}
	
	/**
	*获取格式化日期字符串
	*1.fmt = "包含yMdh
	*2.date = Date对象
	*/
	DateTimeUtil.prototype.dateFtt = function dateFtt(fmt,date)   
	{ //author: meizz   
	  var o = {
	    "MM" : date.getMonth()+1,                 //月份   
	    "dd" : date.getDate(),                    //日   
	    "hh" : date.getHours(),                   //小时   
	    "mm" : date.getMinutes(),                 //分   
	    "ss" : date.getSeconds(),                 //秒   
	    "q+" : Math.floor((date.getMonth()+3)/3)  //季度   
	  };   
	  if(/(y+)/.test(fmt))
	  {
		  fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
	  }
	  for(var k in o)
	  {
		  if(new RegExp("("+ k +")").test(fmt))
		  {
			  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+o[k]).length)));
		  }
	  }
	  if(/(S+)/.test(fmt))
	  {
		  fmt=fmt.replace(RegExp.$1, (date.getMilliseconds()+"").substr(3 - RegExp.$1.length));
	  }
	  return fmt;   
	}
}