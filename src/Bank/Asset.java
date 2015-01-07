package Bank;

import java.util.ArrayList;
import java.util.List;

public class Asset {
	
	private long ID;
	private List<VarCalIntf> varCalList=new ArrayList<VarCalIntf>();

	
	public long getID() {
		return ID;
	}
	public List<VarCalIntf> getVarCalList() {
		return varCalList;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public void addVarCalList(VarCalIntf varCal) {
		this.varCalList.add( varCal);
	}
	
	
	public static void  main(String arg[]){
		Asset asset=new Asset();
		//asset.ID=101L;
		
		VarCalIntf histVar=new HistVarCalImp();
		VarCalIntf mcVar=new MCVarCalImp();
		asset.addVarCalList(histVar);
		asset.addVarCalList(mcVar);
		
		asset.getVarCalList().get(0).varCal(asset.getVarCalList().get(0), asset);
		asset.getVarCalList().get(1).varCal(asset.getVarCalList().get(1), asset);
		
	}
}
