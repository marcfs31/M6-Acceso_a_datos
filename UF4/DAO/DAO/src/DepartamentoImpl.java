import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class DepartamentoImpl implements DepartamentoDAO {
	static ODB db;
	
	
	public DepartamentoImpl() {
		super();
		db = ODBFactory.open("Departamento.DB");
	}

	@Override
	public boolean insertarDep(Departamento dep) {
		
		if (dep == null) {
			return false;
		} else {
			db.store(dep);
			db.commit();
			return true;
		}
	}

	@Override
	public boolean eliminarDep(int deptno) {
		Departamento departamento = consultarDep(deptno);
		
		if (departamento == null) {
			return false;
		} else {
			db.delete(departamento);
			db.commit();
			return true;
		}
	}

	@Override
	public boolean modificarDep(int deptno, Departamento dep) {
		Departamento departamento = consultarDep(deptno);
		
		if (departamento == null || dep == null) {
			return false;
		} else {
			departamento.setDnombre(dep.getDnombre());
			departamento.setLoc(dep.getLoc());
			db.store(departamento);
			db.commit();
			return true;
		}
	}

	@Override
	public Departamento consultarDep(int deptno) {
		ICriterion criterion = Where.equal("deptno", deptno);
		CriteriaQuery query = new CriteriaQuery(Departamento.class, criterion);
		
		Objects<Departamento> departamentos = db.getObjects(query);
		
		if (departamentos.hasNext()) {
			return departamentos.getFirst();
		} else {
			return null;
		}
	}

}
