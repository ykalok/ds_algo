package CodeChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Service {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "";
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		SupplyModel model,model2 = null;
		DemandModel dModel;
		Map<String,List<SupplyModel>> supplyList = new HashMap<String, List<SupplyModel>>();
		List<SupplyModel> newList;
		List<DemandModel> result = new ArrayList<DemandModel>();
		while(sc.hasNextLine()) {
			String  request = sc.nextLine();
			String data[] = request.split(" ");
			model = new SupplyModel();
			model.setOrderId(data[0]);
			model.setTime(data[1]);
			model.setProduce(data[2]);
			model.setPrice(data[3]);
			model.setQuantity(data[4]);
			if(data[0].charAt(0)=='s') {
				if(supplyList.containsKey(data[2])) {
					List<SupplyModel> list = supplyList.get(data[2]);
					list.add(model);
					supplyList.put(data[2], list);
				}else {
					newList = new ArrayList<SupplyModel>();
					newList.add(model);
					supplyList.put(data[2],newList);
				}
			}else if(data[0].charAt(0)=='d') {
				String demand = data[2];
				if(supplyList.containsKey(demand)) {
					List<SupplyModel> list =supplyList.get(demand);
					int size = list.size();
					int orderNo =-1;
					int profit = -1 ;
					for(int i=0;i<size;i++) {
						int maxProfit =Integer.parseInt(model.getPrice())-Integer.parseInt(list.get(i).getPrice());
						if(maxProfit>profit){
							orderNo=i;
							profit = maxProfit;
							model2=list.get(i);
						}
					}
					int quantity = 0;
					if(orderNo!=-1 && profit>=0) {
						dModel = new DemandModel();
						dModel.setDemandOrderId(model.getOrderId());
						dModel.setSupplyOrderId(model2.getOrderId());
						dModel.setPrice(model2.getPrice());
						quantity =Integer.parseInt(model2.getQuantity()) - Integer.parseInt(model.getQuantity());
						if(quantity>0) {
							dModel.setQuantity(model.getQuantity());
						}else {
							dModel.setQuantity(model2.getQuantity());
						}
					}
					if(quantity>0) {
						model2.setQuantity(String.valueOf(quantity));
					}
					else if(quantity<0) {
						
					}
					
				}
			}
		}

	}

}
