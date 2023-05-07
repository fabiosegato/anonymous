

class SettingsService {
    
       deletaItem(confId,key,cb) {

        let xhr = new XMLHttpRequest();        
        xhr.open('DELETE', `/settings/settingName/${confId}/key/${key}`);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    cb(null, `Setting ${confId}  ${key} deletada com sucesso !`);
                } 
            }
        }
    
        xhr.send();

    }

}