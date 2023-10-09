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

import datatypes.DtHora;

public class DtHoraUserType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.TIME };
    }

    @Override
    public Class<DtHora> returnedClass() {
        return DtHora.class;
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
        java.sql.Time sqlTime = rs.getTime(names[0]);
        if (sqlTime != null) {
            // Construye un objeto DtHora a partir de sqlTime
            int horas = sqlTime.getHours();
            int minutos = sqlTime.getMinutes();
            return new DtHora(horas, minutos);
        }
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.TIME);
        } else {
            // Convierte un objeto DtHora en java.sql.Time
            DtHora dtHora = (DtHora) value;
            java.sql.Time sqlTime = new java.sql.Time(dtHora.getHora(), dtHora.getMinuto(), 0);
            st.setTime(index, sqlTime);
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

    
}
