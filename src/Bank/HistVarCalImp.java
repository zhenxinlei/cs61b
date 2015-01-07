package Bank;

public class HistVarCalImp implements VarCalIntf{

	@Override
	public int varCal(VarCalIntf varCalIntf,Asset asset) {
		int a=histVarCal(asset);
		System.out.println("HistVarCal "+a);
		return a;
	}

	private int histVarCal(Asset asset) {
		// TODO Auto-generated method stub
		return 99;
	}
	

}
