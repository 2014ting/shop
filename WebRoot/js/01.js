function create(){
  	var ajax=null;
  	try{
  		//ajax=new ActiveXObject("microsoft:xmlhttp");
  		ajax=new ActiveXObject("microsoft.xmlhttp");
  	
  	}catch(e){
  		ajax=new XMLHttpRequest();
  	}
  return ajax;
  }