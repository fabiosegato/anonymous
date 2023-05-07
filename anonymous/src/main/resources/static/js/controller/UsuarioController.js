class UsuarioController {

    constructor() {
        this._email = document.getElementById('email');
        this._senha = $('#senha');
        this._senhaNova = $('#senhaNova');
        this._senhaNova2 = $('#senhaNova2');
        this._mensagem = new Mensagem();
        this._mensagemView = new MensagemView(document.querySelector('#mensagemView'));
   
    }

    resetPassword(event) {   
    	
    	event.preventDefault();

        let usuario = new ResetUsuario(this._senha[0].value,this._senhaNova[0].value,this._senhaNova2[0].value);
   
        // console.log(usuario);

        let service = new UsuarioService();
        
        if (usuario.senhaNova != usuario.senhaNova2) {
         	this._mensagem.texto = "Os novos passwords não correspondem.";
             this._mensagemView.update(this._mensagem);
             return;
         } 
        else
        {
            service.reset(usuario, (erro,types) => {    	
                if (erro) {
                    console.log(erro);
                    this._mensagem.texto = erro.desc;
                    this._mensagemView.update(this._mensagem);
                    return;
                } 
                console.log("entrou1");
                function alerta()
                {
                    alert("Password atualizado com sucesso!");
                }
                    alerta();
                    window.location.href = "../";
                // this._mensagem.texto = 'Dados gravados com sucesso!';
                // this._mensagemView.update(this._mensagem);
            });
        }
    }
}



