package controladoresCU;

import Hibernate.GestorHibernate;
import ModelosPA.Usuario;
import VistasPA.FrmUsuario;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistroUsuario {

    private GestorHibernate oper;
    private Usuario model;
    private FrmUsuario form;
    private Date date;
    private InicioSesion inicioSesion;

    public RegistroUsuario() {
        oper = new GestorHibernate();

    }

    public InicioSesion getInicioSesion() {
        if (inicioSesion == null) {
            synchronized (InicioSesion.class) {
                inicioSesion = new InicioSesion();
            }
        }
        return inicioSesion;
    }

    public void setInicioSesion(InicioSesion inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    public GestorHibernate getOper() {
        return oper;
    }

    public void setOper(GestorHibernate oper) {
        this.oper = oper;
    }

    public FrmUsuario getForm() {
        return form;
    }

    public void setForm(FrmUsuario form) {
        this.form = form;
    }

    public Usuario getModel() {
        return model;
    }

    public void setModel() {

        model = new Usuario();
        model.setNombre(this.getForm().getTxtNombre().getText());
        model.setPassword(this.getForm().getTxtPassword().getText());
        model.setApellido(this.getForm().getTxtApellido().getText());
        model.setEmail(this.getForm().getTxtEmail().getText());
        model.setDireccion(this.getForm().getTxtDireccion().getText());
        model.setTelefono(this.getForm().getTxtTelefono().getText());
        model.setFechaNac(date);

    }

    public void guardar() {

        if (validar()) {
            this.setModel();
            oper.guardarObjeto(this.getModel());
            JOptionPane.showMessageDialog(null, "Usuario Creado");
            this.getForm().setVisible(false);
            this.getInicioSesion().abrirse();

        }

    }

    private boolean obtenerFecha() {

        try {
            date = this.getForm().getDataFecha().getDate();
            return false;
        } catch (Exception e) {
            return true;
        }

    }

    private boolean validar() {
        String nombs = this.getForm().getTxtNombre().getText();
        String trim = nombs.trim();
        if (trim.length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre a su Usuario");
            return false;
        }
        if (this.getOper().corroborarUsuario(trim) || this.getOper().corroborarComercio(trim) || this.getOper().corroborarAdmin(trim)) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya esta en uso");
            return false;
        }
        obtenerFecha();
        if (date==null) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Fecha de Nacimiento");
            return false;
        }
        
        if ("".equals(this.getForm().getTxtPassword().getText())) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una Contrase�a");
            return false;
        }
        
        
        String direccion = this.getForm().getTxtDireccion().getText();
        trim = direccion.trim();
        if (trim.length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una direcci�n");
            return false;
        }

        return true;
    }

    public void abrirse() {
        new FrmUsuario().setVisible(true);
    }
}
