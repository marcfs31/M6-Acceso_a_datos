package control;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class BaseDatos {
	static ODB odb;

	public BaseDatos() {
		odb = ODBFactory.open("departamento.DB");
	}

	public void insertarDepartamento(Departamento departamento) {
		odb.store(departamento);
		odb.commit();
	}
	
	public Departamento recuperarDepartamento(int deptno) {
		ICriterion criterio = Where.equal("deptno", deptno);
		CriteriaQuery query = new CriteriaQuery(Departamento.class, criterio);
		Objects<Departamento> departamentos = odb.getObjects(query);
		if (departamentos.hasNext()) {
			return departamentos.getFirst();
		} else {
			return null;
		}
	}

	public void cerrarBD() {
		odb.close();
	}	
}
