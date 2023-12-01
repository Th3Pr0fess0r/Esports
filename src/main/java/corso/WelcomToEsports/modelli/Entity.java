package corso.WelcomToEsports.modelli;

public abstract class Entity {
    private int id;

    public Entity () {
    	
    }
	public Entity(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
    
    
    
    
}


