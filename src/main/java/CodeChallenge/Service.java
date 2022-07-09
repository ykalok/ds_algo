package CodeChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Service implements Comparator<SupplyModel> {
	@Override
	public int compare(SupplyModel o1, SupplyModel o2) {
		return 0;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "";
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		SupplyModel model, model2 = null;
		//OutputModel dModel;
		Map<String, PriorityQueue<SupplyModel>> supplyList = new HashMap<String, PriorityQueue<SupplyModel>>();
		Map<String, List<SupplyModel>> demandList = new HashMap<String, List<SupplyModel>>();
		List<OutputModel> result = new ArrayList<OutputModel>();
		while (sc.hasNextLine()) {
			String request = sc.nextLine();
			String data[] = request.split(" ");
			model = new SupplyModel();
			model.setOrderId(data[0]);
			model.setTime(data[1]);
			model.setProduce(data[2]);
			model.setPrice(Integer.parseInt(data[3].replaceAll("\\D+", "")));
			model.setQuantity(Integer.parseInt(data[4].replaceAll("\\D+", "")));
			if (data[0].charAt(0) == 's') {
				String supply = data[2];
				if (supplyList.containsKey(supply)) {
					PriorityQueue<SupplyModel> list = supplyList.get(data[2]);
					list.add(model);
					supplyList.put(supply, list);
				} else {
					PriorityQueue<SupplyModel> newList = new PriorityQueue<SupplyModel>(new Service());
					newList.add(model);
					supplyList.put(supply, newList);
				}

				if (demandList.containsKey(supply) && demandList.get(supply).size() > 0) {
					List<SupplyModel> demandRemains = demandList.get(supply);
					int n = demandRemains.size();
					PriorityQueue<SupplyModel> list = supplyList.get(supply);
					SupplyModel pqModel = list.peek();
					int sQuantity = pqModel.getQuantity();
					int sPrice = pqModel.getPrice();
					list.poll();
					for (int i = 0; i < n; i++) {
						SupplyModel model1 = demandRemains.get(i);
						int quantity;
						if (model1.getPrice() >= sPrice) {
							if (sQuantity > 0) {
								quantity = sQuantity - model1.getQuantity();
								OutputModel oModel = new OutputModel();
								if (quantity >= 0) {
									oModel.setDemandOrderId(model1.getOrderId());
									oModel.setDemandOrderId(pqModel.getOrderId());
									oModel.setQuantity(model1.getQuantity());
									oModel.setPrice(model1.getPrice());
									result.add(oModel);
									demandRemains.remove(i);
									sQuantity = sQuantity - model1.getQuantity();
								} else if (quantity < 0) {
									oModel.setDemandOrderId(model1.getOrderId());
									oModel.setDemandOrderId(pqModel.getOrderId());
									oModel.setQuantity(sQuantity);
									oModel.setPrice(model1.getPrice());
									result.add(oModel);
									int remainQuant = model1.getQuantity() - sQuantity;
									model1.setQuantity(remainQuant);
									demandRemains.set(i, model1);
									break;
								}

							}
						} else {
							break;
						}
					}
					if (sQuantity > 0) {
						pqModel.setQuantity(sQuantity);
						list.add(pqModel);
						supplyList.put(supply, list);
					}

				}
			} else if (data[0].charAt(0) == 'd') {
				String demand = data[2];
				if (supplyList.containsKey(demand) && supplyList.get(demand).size() > 0) {
					PriorityQueue<SupplyModel> list = supplyList.get(demand);
					SupplyModel pqModel = list.peek();
					int sQuantity = pqModel.getQuantity();
					int sPrice = pqModel.getPrice();
					list.poll();
					int quantity;
					if (model.getPrice() >= sPrice) {
						if (sQuantity > 0) {
							quantity = sQuantity - model.getQuantity();
							OutputModel oModel = new OutputModel();
							if (quantity >= 0) {
								oModel.setDemandOrderId(model.getOrderId());
								oModel.setDemandOrderId(pqModel.getOrderId());
								oModel.setQuantity(model.getQuantity());
								oModel.setPrice(model.getPrice());
								result.add(oModel);
								// demandRemains.remove(i);
								sQuantity = sQuantity - model.getQuantity();
							} else if (quantity < 0) {
								oModel.setDemandOrderId(model.getOrderId());
								oModel.setDemandOrderId(pqModel.getOrderId());
								oModel.setQuantity(sQuantity);
								oModel.setPrice(model.getPrice());
								result.add(oModel);
								int remainQuant = model.getQuantity() - sQuantity;
								model.setQuantity(remainQuant);
								while(list.size()>0) {
									pqModel = list.peek();
									sQuantity = pqModel.getQuantity();
									sPrice = pqModel.getPrice();
									list.poll();
									if (model.getPrice() >= sPrice) {
										if (remainQuant > 0) {
											quantity = sQuantity - remainQuant;
											oModel = new OutputModel();	
											if (quantity >= 0) {
												oModel.setDemandOrderId(model.getOrderId());
												oModel.setDemandOrderId(pqModel.getOrderId());
												oModel.setQuantity(remainQuant);
												oModel.setPrice(model.getPrice());
												result.add(oModel);
												sQuantity = sQuantity -remainQuant;
												if(sQuantity>0) {
													pqModel.setQuantity(sQuantity);
													list.add(pqModel);
													supplyList.put(demand, list);
												}
												break;
											}else {
												oModel.setDemandOrderId(model.getOrderId());
												oModel.setDemandOrderId(pqModel.getOrderId());
												oModel.setQuantity(sQuantity);
												oModel.setPrice(model.getPrice());
												result.add(oModel);
												remainQuant =remainQuant-sQuantity;
											}
										}
										else {
											list.add(pqModel);
											supplyList.put(demand, list);
											break;
										}
									}else {
										list.add(pqModel);
										supplyList.put(demand, list);
										model.setQuantity(remainQuant);
//										if()
//										demandList.put(demand, null)
										
										break;
									}
								}
//								demandRemains.set(i, model);
//								break;
							}
						}

					}else {
						if (demandList.containsKey(demand)) {
							List<SupplyModel> list1 = demandList.get(data[2]);
							list1.add(model);
							demandList.put(demand, list1);
						} else {
							List<SupplyModel> newList1 = new ArrayList<SupplyModel>();
							newList1.add(model);
							demandList  .put(demand, newList1);
						}
						
					}

				}
			}
		}

	}

}
