package logica;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import datatypes.DtFecha;

public class DtFechaUserType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.DATE };
    }

    @Override
    public Class<DtFecha> returnedClass() {
        return DtFecha.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
    	String fecha = rs.getString(names[0]);
    	String[] partes = fecha.split("-");
    	int anio = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);
        //int dia = rs.getInt(names[0]);
        //int mes = rs.getInt(names[1]);
        //int anio = rs.getInt(names[2]);
        return new DtFecha(dia, mes, anio);
    }

    @SuppressWarnings("deprecation")
	@Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.DATE);
        } else {
            DtFecha fecha = (DtFecha) value;
            st.setDate(index, new java.sql.Date(fecha.getAnio(), fecha.getMes(), fecha.getDia()));
        }
    }

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

    // Implementa otros métodos de la interfaz UserType según sea necesario.
}
