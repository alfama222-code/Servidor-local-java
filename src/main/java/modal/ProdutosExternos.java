package modal;

public class ProdutosExternos {
    private Integer id;
    private String title;
    private String description;
    String category;
    Double price;


    public void  setId (Integer id) {
        this.id=id;
    }
    public Integer getid () {
        return this.id;
    }
    public void setTitle (String title) {
        this.title=title;
    }
    public String getTitle (){
        return this.title;
    }
    public void setDescription (String description) {
        this.description=description;
    }
    public  String getDescription () {
        return this.description;
    }
    public void setCategory (String category) {
        this.category=category;
    }
    public String getCategory () {
        return this.category;
    }
    public void setPrice (String price) {
        this.category=category;
    }
    public Double  getPrice () {
        return this.price;
    }
}

