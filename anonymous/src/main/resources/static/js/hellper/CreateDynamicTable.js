class CreateDynamicTable {

      constructor(pModel) {

        this.model = pModel;        

    }
    
    _createHeader(){
    
    let headers = Object.getOwnPropertyNames(this.model);
    let html = '';
     headers.forEach((element) => {
			
			html += `<th scope="col" class="px-6 py-3">"${element}"</th>`;
           
        });
        return html;
       
    }
    
    _createLine(){
    }
    
    createTable(){
		
		return this._createHeader();
		
	}

    

}