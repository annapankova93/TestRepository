"use strict";(function(root,factory){if(typeof define==="function"&&define.amd){define(["./jolokia"],factory);}else if(typeof module==="object"&&module.exports){module.exports=factory(require("./jolokia"));}else{if(root.Jolokia){factory(root.Jolokia);}else{console.error("No Jolokia definition found. Please include jolokia.js before jolokia-simple.js");}}}(typeof self!=="undefined"?self:this,function(Jolokia){var builder=function(Jolokia){function getAttribute(mbean,attribute,path,opts){if(arguments.length===3&&isPlainObject(path)){opts=path;path=null;}else if(arguments.length==2&&isPlainObject(attribute)){opts=attribute;attribute=null;path=null;}
var req={type:"read",mbean:mbean,attribute:attribute};addPath(req,path);return extractValue(this.request(req,prepareSuccessCallback(opts)),opts);}
function setAttribute(mbean,attribute,value,path,opts){if(arguments.length===4&&isPlainObject(path)){opts=path;path=null;}
var req={type:"write",mbean:mbean,attribute:attribute,value:value};addPath(req,path);return extractValue(this.request(req,prepareSuccessCallback(opts)),opts);}
function execute(mbean,operation){var req={type:"exec",mbean:mbean,operation:operation};var opts,end=arguments.length;if(arguments.length>2&&isPlainObject(arguments[arguments.length-1])){opts=arguments[arguments.length-1];end=arguments.length-1;}
if(end>2){var args=[];for(var i=2;i<end;i++){args[i-2]=arguments[i];}
req.arguments=args;}
return extractValue(this.request(req,prepareSuccessCallback(opts)),opts);}
function search(mbeanPattern,opts){var req={type:"search",mbean:mbeanPattern};return extractValue(this.request(req,prepareSuccessCallback(opts)),opts);}
function version(opts){return extractValue(this.request({type:"version"},prepareSuccessCallback(opts)),opts);}
function list(path,opts){if(arguments.length==1&&!Array.isArray(path)&&isPlainObject(path)){opts=path;path=null;}
var req={type:"list"};addPath(req,path);return extractValue(this.request(req,prepareSuccessCallback(opts)),opts);}
function addPath(req,path){if(path!=null){if(Array.isArray(path)){req.path=path.map(Jolokia.escape).join("/");}else{1
req.path=path;}}}
function extractValue(response,opts){if(response==null){return null;}
if(response.status==200){return response.value;}
if(opts&&opts.error){return opts.error(response);}else{throw new Error("Jolokia-Error: "+JSON.stringify(response));}}
function prepareSuccessCallback(opts){if(opts&&opts.success){var parm=Jolokia.assignObject({},opts);parm.success=function(resp){opts.success(resp.value);};return parm;}else{return opts;}}
function isPlainObject(obj){return obj&&Object.prototype.toString.call(obj)==="[object Object]";}
Jolokia.assignObject(Jolokia.prototype,{"getAttribute":getAttribute,"setAttribute":setAttribute,"execute":execute,"search":search,"version":version,"list":list});return Jolokia;};return builder(Jolokia);}));