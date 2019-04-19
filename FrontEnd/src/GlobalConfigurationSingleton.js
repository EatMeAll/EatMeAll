export default class GlobalConfigurationSingleton {

    static instance;

    static getInstance(){
        if(this.instance === undefined){
            this.instance = new GlobalConfigurationSingleton();
        }
        return this.instance;
    }

    constructor(){
        this.users = ["Dianka", "pSZemcio"];
    }

}