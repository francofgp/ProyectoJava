package Hibernate;

import GUtilr.Util;
import ModelosPA.Admin;
import ModelosPA.Categoria;
import ModelosPA.Comercio;
import ModelosPA.Producto;
import ModelosPA.Rubro;
import ModelosPA.Usuario;
import ModelosPA.Pedido;
//import Modelos.GestionProyecto.Usuario;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.openSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import org.hibernate.jdbc.Work;
//import Modelos.GestionProyecto.Usuario;

public class GestorHibernate extends HibernateUtil {

    public static void Usuario(String text, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Transaction tx;

    /**
     * Elimina un objeto del repositorio
     *
     * @param objeto Objeto a eliminar
     */
    public void eliminarObjeto(Object objeto) {
        try {
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();
            s.delete(objeto);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Repositorio.eliminarObjeto(Object objeto)" + ex);
            ex.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, "El elemento no se puede eliminar:" + ex.getMessage(), "Error", 0);
            getTx().rollback();
        }
    }

    public void guardarObjeto(Object objeto) {
        try {
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();
            s.save(objeto);
            tx.commit();

            System.out.println(" guardaractualizarObjeto() " + objeto.getClass() + ": " + objeto.toString());
        } catch (Exception ex) {
            System.out.println("error " + ex);
            System.out.println("Repositorio.guardarObjeto(Object objeto)" + objeto.getClass() + ": " + objeto.toString() + ex);
            ex.printStackTrace();
            getTx().rollback();
        }
    }

    public void guardarUsuario(Object objeto) {

        //esto es copiado y pegado, basicamente a todo lo que estaba antes lo guarda, sin verificar nada
        // le paso el objeto que lo cree en el FRMusuario, aca se puede hacer comprobaciones supongo, ya que es el gestor
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        // objeto.setApellido("asd");
        // objeto.setNombre("asdasd");
        // objeto.setId(2);
        s.save(objeto);
        tx.commit();
    }

    public void modificarUsuario(String nombre, String descripcion, Long ID) {

        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();

        Rubro rubro = (Rubro) s.createCriteria(Rubro.class)
                .add(Restrictions.eq("id", ID)).uniqueResult();

        rubro.setDescripcion(descripcion);
        rubro.setNombre(nombre);
        s.update(rubro);
        tx.commit();

        /**
         * *
         * //esto es copiado y pegado, basicamente a todo lo que estaba antes
         * lo guarda, sin verificar nada // le paso el objeto que lo cree en el
         * FRMusuario, aca se puede hacer comprobaciones supongo, ya que es el
         * gestor Session s = HibernateUtil.getSession(); Transaction tx =
         * s.beginTransaction(); // objeto.setApellido("asd"); //
         * objeto.setNombre("asdasd"); // objeto.setId(2); s.save(objeto);
         * tx.commit(); **
         */
    }
    //implementar al menos 3 try y catch

    public void modificarCategoria(String nombre, String descripcion, Long ID) {

        try {
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();

            Categoria categoria = (Categoria) s.createCriteria(Categoria.class)
                    .add(Restrictions.eq("id", ID)).uniqueResult();

            categoria.setDescripcion(descripcion);
            categoria.setNombre(nombre);
            s.update(categoria);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la categoria " + e.getMessage(), " Error ", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Actualiza un objeto en el repositorio
     *
     * @param objeto Objeto a actualizar
     */
    public boolean actualizarObjeto(Object objeto) {
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try {
            s.update(objeto);
            tx.commit();
            System.out.println(" actualizarObjeto() " + objeto.getClass() + ": " + objeto.toString());
            return true;
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e);
            tx.rollback();
            JOptionPane.showMessageDialog(null, "No se pueden guardar los datos. \nLos mismos han sido modificados por otra persona.");
//            this.clearCache(); //puso juan

            return false;
        }
    }

    public static List<Rubro> rubroShow() {
        Session sesion = HibernateUtil.getSession();
        List<Rubro> rubro = session.createCriteria(Rubro.class).list();
        return rubro;

    }

    public static List<Comercio> buscarComercioPorCategoriaYRubro(String nombre) {
        Session sesion = HibernateUtil.getSession();
        List<Comercio> comercio = session.createCriteria(Comercio.class)
                .add(Restrictions.like("nombre", "%"+nombre+"%")).list();
        return comercio;

    }

    public static List<Comercio> buscarComercioPorCategoriaYRubro(Categoria categoria, Rubro rubro) {
        Session sesion = HibernateUtil.getSession();
        List<Comercio> comercio = session.createCriteria(Comercio.class)
                .createAlias("categoria", "cat")
                .createAlias("rubro", "rub")
                .add(Restrictions.eq("cat.nombre", categoria.getNombre()))
                .add(Restrictions.eq("rub.nombre", rubro.getNombre())).list();

        return comercio;

    }

    public static List<Producto> BuscarProducto() {
        Session sesion = HibernateUtil.getSession();
        List<Producto> producto = session.createCriteria(Producto.class).list();
        return producto;

    }

    public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }

    public List listarClase(Class clase) {
        Criteria crit = getSession().createCriteria(clase);
        return crit.list();
    }

    public List listarClase(Class clase, String atributoOrden, int estado) {
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.asc(atributoOrden))
                .add(Restrictions.eq("estado", estado));
        return crit.list();
    }

    public List listarClase(Class clase, String atributoOrden) {
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.asc(atributoOrden));
        return crit.list();
    }

//    public Integer listarUltimo(Class clase) {
//        Criteria crit = getSession().createCriteria(clase);
//        crit.setProjection(Projections.max("codigo"));
//        return Util.convertirToInteger(crit.uniqueResult());
//    }
    public List listarUltimo(Class clase) {
        Criteria crit = getSession().createCriteria(clase)
                .addOrder(Order.desc("codigo"));
        return crit.list();
    }

    public List listarClaseCodigo(Class clase, int valor) {
        Criteria crit = getSession().createCriteria(clase)
                .add(Restrictions.eq("codigo", valor))
                .add(Restrictions.eq("estado", 0));
        return crit.list();
    }

    public Object listarClaseCodigoUnique(Class clase, int valor) {
        Criteria crit = getSession().createCriteria(clase)
                .add(Restrictions.eq("codigo", valor))
                .add(Restrictions.eq("estado", 0));
        return crit.uniqueResult();
    }
    //implementar al menos 3 try y catch

    public void eliminar(Long ID) {

        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try {
            Class clase = (Class) s.createCriteria(Class.class)
                    .add(Restrictions.eq("id", ID)).uniqueResult();

            s.delete(clase);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el rubro ya que lo tiene seleccionado un comercio " /*+ e.getMessage()*/, " Error ", JOptionPane.ERROR_MESSAGE);
            //getTx().rollback();

        }

//este metodo era originalmente elimnarrubro,reemplez� todos los nombre por clase
    }
    //implementar al menos 3 try y catch

    public void eliminarCategoria(Long ID) {

        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();

        try {
            Categoria categoria = (Categoria) s.createCriteria(Categoria.class)
                    .add(Restrictions.eq("id", ID)).uniqueResult();

            s.delete(categoria);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la categoria ya que la tiene seleccionada un comercio" /*+ e.getMessage()*/, " Error ", JOptionPane.ERROR_MESSAGE);
            //getTx().rollback();
        }

    }

    public List<Categoria> categoriaShow() {
        Session sesion = HibernateUtil.getSession();
        List<Categoria> categoria = session.createCriteria(Categoria.class).list();
        return categoria;
    }

    public long buscarObjeto(String nombre) {

        Session sesion = HibernateUtil.getSession();

        Rubro rubro = (Rubro) sesion.createCriteria(Rubro.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();
        System.out.println(rubro.getId());
        return rubro.getId();
    }

    public Object buscarObjetoPorId(Long id) {

        Session sesion = HibernateUtil.getSession();

        Rubro rubro = (Rubro) sesion.createCriteria(Rubro.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        System.out.println(rubro.getId());
        return rubro;
    }

    public long buscarCategoria(String nombre) {

        Session sesion = HibernateUtil.getSession();

        Categoria categoria = (Categoria) sesion.createCriteria(Categoria.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();
        System.out.println(categoria.getId() + " categoria");
        return categoria.getId();
    }

    public void reporteRubro() {
        //saqu� de este video de youtube: https://www.youtube.com/watch?v=2DvwZmsHfgo&t=23s
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            /*
            session.doWork(new Work() {
                public void execute(Connection connection) throws SQLException {
                    //use the connection here...
                }
            });
             */
            SessionImpl sessionImpl = (SessionImpl) session;
            Connection connection = sessionImpl.connection();
            //File file = new File("");
            JasperReport archivo = JasperCompileManager.compileReport("rubro.jrxml");
            // Map<String,Object> map = new HashMap<String, Object>();
            //Conectar con = new Conectar("jdbc:mysql://localhost/productos");
            //JRDataSource data = new JREmptyDataSource();
            JasperPrint prin = JasperFillManager.fillReport(archivo, null, connection);
            JasperExportManager.exportReportToPdfFile(prin, "reporte.pdf");

            JasperPrint jprint = JasperFillManager.fillReport(archivo, null, connection);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(2);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(GestorHibernate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Object buscarCategoriaPorId(Long idCategoriaSeleccionado) {
        Session sesion = HibernateUtil.getSession();

        Categoria categoria = (Categoria) sesion.createCriteria(Categoria.class)
                .add(Restrictions.eq("id", idCategoriaSeleccionado)).uniqueResult();
        System.out.println(categoria.getId());
        return categoria;
    }

    public Object buscarProducto(Long idProducto) {
        Session sesion = HibernateUtil.getSession();

        Producto producto = (Producto) sesion.createCriteria(Producto.class)
                .add(Restrictions.eq("id", idProducto)).uniqueResult();
        //System.out.println(producto.getId());
        return producto;
    }

    public Object buscarComercio(Long idProducto) {
        Session sesion = HibernateUtil.getSession();

        Comercio comercio = (Comercio) sesion.createCriteria(Comercio.class)
                .add(Restrictions.eq("id", idProducto)).uniqueResult();
        //System.out.println(producto.getId());
        return comercio;
    }

    public boolean ingresarComercio(String username, String password) {
        Session sesion = HibernateUtil.getSession();

        Comercio comercio = (Comercio) sesion.createCriteria(Comercio.class)
                .add(Restrictions.eq("nombre", username)).uniqueResult();

        try {
            if (comercio != null) {

                if (comercio.getPassword().equals(password)) {
                    //JOptionPane.showMessageDialog(null, "Bienvenido Comercio "+comercio.getNombre());
                    //lo saco de aca porque spamea mucho sino
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error la contrase�a ingresada "
                            + "no corresponde con el comercio", "", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "El comercio "
                        + " no existe", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El comercio "
                    + " no existe", "", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return false;
        }
    }

    public Comercio buscarComercioLogin(String username, String password) {
        Session sesion = HibernateUtil.getSession();

        try {
            Comercio comercio = (Comercio) sesion.createCriteria(Comercio.class)
                    .add(Restrictions.eq("nombre", username))
                    .add(Restrictions.eq("password", password)).uniqueResult();

            return comercio;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario o Contrase�a incorrecta ",
                    " ", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return null;
        }
    }

    public boolean ingresarUsuario(String username, String password) {
        Session sesion = HibernateUtil.getSession();

        Usuario usuario = (Usuario) sesion.createCriteria(Usuario.class)
                .add(Restrictions.eq("nombre", username)).uniqueResult();

        try {
            if (usuario != null) {

                if (usuario.getPassword().equals(password)) {
                    //JOptionPane.showMessageDialog(null, "Bienvenido Comercio "+comercio.getNombre());
                    //lo saco de aca porque spamea mucho sino
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error la contrase�a ingresada "
                            + "no corresponde con el usuario", "", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario "
                        + " no existe", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario "
                    + " no existe", "", JOptionPane.ERROR_MESSAGE);
            //System.out.println(e);
            return false;
        }
    }

    public boolean ingresarAdmin(String username, String password) {
        Session sesion = HibernateUtil.getSession();

        Admin admin = (Admin) sesion.createCriteria(Admin.class)
                .add(Restrictions.eq("class", Admin.class))
                .add(Restrictions.eq("nombre", username)).uniqueResult();

        if (admin != null) {
            if (admin.getPassword().equals(password)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public Comercio buscarComercioIngresante(String username, String password) {
        Session sesion = HibernateUtil.getSession();

        Comercio comercio = (Comercio) sesion.createCriteria(Comercio.class)
                .add(Restrictions.eq("nombre", username)).uniqueResult();

        try {
            if (comercio != null) {

                if (comercio.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido Comercio " + comercio.getNombre());
                    return comercio;
                } else {
                    JOptionPane.showMessageDialog(null, "Error la contrase�a ingresada "
                            + "no corresponde con el usuario", "", JOptionPane.ERROR_MESSAGE);
                    return null;
                }

            } else {
                JOptionPane.showMessageDialog(null, "El comercio " + comercio.getNombre()
                        + " no existe", "", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El comercio " + comercio.getNombre()
                    + " no existe", "", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return null;
        }
    }

    public Usuario buscarUsuarioIngresante(String username, String password) {
        Session sesion = HibernateUtil.getSession();

        Usuario usuario = (Usuario) sesion.createCriteria(Usuario.class)
                .add(Restrictions.eq("nombre", username)).uniqueResult();

        try {
            if (usuario != null) {

                if (usuario.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido Usuario " + usuario.getNombre());
                    return usuario;
                } else {
                    JOptionPane.showMessageDialog(null, "Error la contrase�a ingresada "
                            + "no corresponde con el Usuario", "", JOptionPane.ERROR_MESSAGE);
                    return null;
                }

            } else {
                JOptionPane.showMessageDialog(null, "El Usuario " + usuario.getNombre()
                        + " no existe", "", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Usuario " + usuario.getNombre()
                    + " no existe", "", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return null;
        }
    }

    public boolean corroborarRubro(String nombre) {
        Session sesion = HibernateUtil.getSession();

        Rubro rubro = (Rubro) sesion.createCriteria(Rubro.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();

        try {
            if (rubro != null) {
                String nom = rubro.getNombre();
                if (nom.equals(nombre)) {
                    //JOptionPane.showMessageDialog(null, "El rubro " + rubro.getNombre() + " ya existe!", "", JOptionPane.ERROR_MESSAGE);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public void eliminarRubro(Long ID) {
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try {
            Rubro rubro = (Rubro) s.createCriteria(Rubro.class)
                    .add(Restrictions.eq("id", ID)).uniqueResult();
            s.delete(rubro);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el rubro ya que lo tiene seleccionado un comercio " /*+ e.getMessage()*/, " Error ", JOptionPane.ERROR_MESSAGE);
            //getTx().rollback();

        }
    }

    public void darDeBajaRubro(Rubro rubro) {
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try {
            rubro.setEstado("Dado de Baja");
            s.update(rubro);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja al rubro ", " Error ", JOptionPane.ERROR_MESSAGE);
            //getTx().rollback();

        }
    }

    public void cancelar(Pedido pedido) {
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try {
            pedido.setEstado("Cancelado");
            s.update(pedido);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja al rubro ", " Error ", JOptionPane.ERROR_MESSAGE);
            //getTx().rollback();

        }
    }

    public void darDeBajaCategoria(Categoria categoria) {
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        try {
            categoria.setEstado("Dado de Baja");
            s.update(categoria);
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja a la categoria ", " Error ", JOptionPane.ERROR_MESSAGE);

        }
    }

    public boolean corroborarCategoria(String nombre) {
        Session sesion = HibernateUtil.getSession();

        Categoria categoria = (Categoria) sesion.createCriteria(Categoria.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();

        try {
            if (categoria != null) {
                String nom = categoria.getNombre();
                if (nom.equals(nombre)) {
                    //JOptionPane.showMessageDialog(null, "La categor�a " + categoria.getNombre() + " ya existe!", "", JOptionPane.ERROR_MESSAGE);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public boolean corroborarUsuario(String nombre) {
        Session sesion = HibernateUtil.getSession();

        Usuario usuario = (Usuario) sesion.createCriteria(Usuario.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();

        try {
            if (usuario != null) {
                String nom = usuario.getNombre();
                return nom.equals(nombre); //JOptionPane.showMessageDialog(null, "La categor�a " + categoria.getNombre() + " ya existe!", "", JOptionPane.ERROR_MESSAGE);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public static List<Producto> BuscarProducto(Categoria categoria, Comercio comercio) {
        Session sesion = HibernateUtil.getSession();

        List<Producto> producto = session.createCriteria(Producto.class)
                .createAlias("categoria", "cat")
                .createAlias("comercio", "com")
                .add(Restrictions.eq("cat.nombre", categoria.getNombre()))
                .add(Restrictions.eq("com.nombre", comercio.getNombre())).list();

        return producto;

    }
    
    public static List<Producto> BuscarProducto(Comercio comercio) {
        Session sesion = HibernateUtil.getSession();

        List<Producto> producto = session.createCriteria(Producto.class)
                .createAlias("comercio", "com")
                .add(Restrictions.eq("com.nombre", comercio.getNombre())).list();

        return producto;

    }

    public static List<Pedido> buscarPedido(Usuario usuario) {
        Session sesion = HibernateUtil.getSession();

        List<Pedido> pedido = session.createCriteria(Pedido.class)
                .createAlias("usuario", "usu")
                .add(Restrictions.eq("usu.nombre", usuario.getNombre()))
                .list();

        return pedido;

    }

    public static List<Pedido> buscarPedidoComercio(Comercio comercio) {
        Session sesion = HibernateUtil.getSession();

        List<Pedido> pedido = session.createCriteria(Pedido.class)
                .createAlias("comercio", "com")
                .add(Restrictions.eq("com.nombre", comercio.getNombre()))
                .list();

        return pedido;

    }

    public boolean corroborarAdmin(String nombre) {
        Session sesion = HibernateUtil.getSession();

        Admin admin = (Admin) sesion.createCriteria(Admin.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();

        try {
            if (admin != null) {
                String nom = admin.getNombre();
                return nom.equals(nombre); //JOptionPane.showMessageDialog(null, "La categor�a " + categoria.getNombre() + " ya existe!", "", JOptionPane.ERROR_MESSAGE);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public boolean corroborarComercio(String nombre) {
        Session sesion = HibernateUtil.getSession();

        Comercio comercio = (Comercio) sesion.createCriteria(Comercio.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();

        try {
            if (comercio != null) {
                String nom = comercio.getNombre();
                return nom.equals(nombre); //JOptionPane.showMessageDialog(null, "La categor�a " + categoria.getNombre() + " ya existe!", "", JOptionPane.ERROR_MESSAGE);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public Usuario buscarUsuarioLogin(String username, String password) {

        Session sesion = HibernateUtil.getSession();

        try {
            Usuario usuario = (Usuario) sesion.createCriteria(Usuario.class)
                    .add(Restrictions.eq("nombre", username))
                    .add(Restrictions.eq("password", password)).uniqueResult();

            return usuario;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario o Contrase�a incorrecta ",
                    " ", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return null;

        }

    }

    public List<Comercio> buscarComercioPorNombre(String nombreComercio) {
        Session sesion = HibernateUtil.getSession();
        List<Comercio> comercio = session.createCriteria(Comercio.class)
                .add(Restrictions.like("nombre", "%"+nombreComercio+"%")).list();
        return comercio;
        
    }



}
