class Cookie {

setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    console.log(cname + "=" + cvalue + ";" + expires + ";path=/;");
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/;SameSite=yes;";
    //console.log(document.cookie);
  }
  
  _getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }  

  checkCookie() {
    var token = this._getCookie("token_anonymous");
    if (token == "") {
      return '';
    }
      return token; 
    }


getCookie(cookieSeuNome)
{
var c_name = document.cookie; // listando o nome de todos os cookies
console.log(c_name);
if(c_name!=undefined && c_name.length > 0) // verificando se o mesmo existe
{
var posCookie = c_name.indexOf(cookieSeuNome); // checando se existe o cookieSeuNome 
if (posCookie >= 0) //se existir o cookie mostra um alert no browser
{
alert("Cookie Existe!!!");
}
else
alert("Cookie não existe!!!");
}

}

}