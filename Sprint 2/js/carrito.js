function accion(){
    var ancla = document.getElementsByClassName('nav-enlace');
    for(var i = 0; i < ancla.lenght; i++){
        ancla[i].classList.toggle('desaparece')
    }
}