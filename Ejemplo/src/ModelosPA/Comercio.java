package ModelosPA;

import java.io.Serializable;
import java.util.Date;
import static javax.persistence.CascadeType.MERGE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "comercio")
public class Comercio implements Serializable {

    public Comercio(String nombre, String apellido, Date fechaNac, String password, String direccion,
            String correo, String cuil, String telefono, String nombreLocal, String direccionNegocio,
            Rubro rubro, Categoria categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.password = password;
        this.direccion = direccion;
        this.correo = correo;
        this.cuil = cuil;
        this.telefono = telefono;
        this.nombreLocal = nombreLocal;
        this.direccionNegocio = direccionNegocio;
        this.rubro = rubro;
        this.categoria = categoria;
    }

    public Comercio() {
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String apellido;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;

    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    private String password;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @Column(columnDefinition = "TEXT")
    private String correo;

    @Column(columnDefinition = "TEXT")
    private String cuil;

    @Column(columnDefinition = "TEXT")
    private String telefono;

    @Column(columnDefinition = "TEXT")
    private String nombreLocal;

    @ManyToOne(targetEntity = Rubro.class, cascade = MERGE, fetch = FetchType.LAZY)
    private Rubro rubro;

    @ManyToOne(targetEntity = Categoria.class, cascade = MERGE, fetch = FetchType.LAZY)
    private Categoria categoria;

    @Column(columnDefinition = "TEXT")
    private String direccionNegocio;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getPassword() {
        return password;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCuil() {
        return cuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public String getDireccionNegocio() {
        return direccionNegocio;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public void setDireccionNegocio(String direccionNegocio) {
        this.direccionNegocio = direccionNegocio;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
