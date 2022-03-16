package Day11;

public class MySqlDao implements DataAccessObject {

	
	@Override
	public void delete() {
		System.out.println("오라클 MySql에서 삭제");
	}
	@Override
	public void insert() {
		System.out.println("오라클 MySql에 삽입");
	}
	@Override
	public void select() {
		System.out.println("오라클 MySql에서 검색");
	}
	
	@Override
	public void update() {
		System.out.println("오라클 MySql를 수정");
	}
	
}
