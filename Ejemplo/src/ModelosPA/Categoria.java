package ModelosPA;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="categoria") 

public class Categoria {
    
    public Categoria( String nombre, String apellido) {   
        //this.id = id;
        //creamos el constructor para los datos que le vamos a pasar, pero el ID no porque es autoincremental
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Categoria(){
    
    }
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    
    @Column(columnDefinition = "TEXT")
    String nombre;
    
    @Column(columnDefinition = "TEXT")
    String descripcion;
        
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }    


    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
