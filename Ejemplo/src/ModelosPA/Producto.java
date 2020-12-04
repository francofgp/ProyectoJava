package ModelosPA;

import java.io.Serializable;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    public Producto() {
    }

    public Producto(String nombre, String descripcion, float precio, Categoria categoria, Comercio comercio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.comercio = comercio;
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String estado;
    private float precio;

    @OneToOne(targetEntity = Categoria.class, cascade = MERGE, fetch = FetchType.LAZY)
    public Categoria categoria;

    @ManyToOne(targetEntity = Comercio.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Comercio comercio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

}
