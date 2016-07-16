package com.jamesanton.ai.javaclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jamesanton.ai.util.RandomUtil;

public class ClassBody {
	private List<String> bodyItems;

	public ClassBody() {
		bodyItems = new ArrayList<String>();
	}

	public ClassBody(ClassBody classBody) {
		bodyItems = new ArrayList<String>(classBody.bodyItems);
	}

	/**
	 * Adds an item to a random index of the class body.
	 * Ensures that a variable name cannot be beside another variable name
	 * @param item
	 */
	public void addToRandomIndex(String item) {
		if (bodyItems.size() == 0) {
			bodyItems.add(item);
		} else {
			int desiredInsertIndex = RandomUtil.getRandomNumberStartingFromZero(bodyItems.size());
			
			// If its not a variable, then go ahead and insert it
			if(!item.startsWith("VAR")){
				bodyItems.add(desiredInsertIndex, item);
			}else{
				// We want to add a variable name, 
				// lets make sure its not going to be inserted next to another variable name.
				int neighbor1Index = desiredInsertIndex;
				if(!bodyItems.get(neighbor1Index).startsWith("VAR")){
					// If there is another neighbor we need to check it too, but if not then insert it
					if(neighbor1Index == bodyItems.size() - 1){
						// There is no second neighbor
						bodyItems.add(item);
					}else{
						// There is a second neighbor, make sure its not a variable name
						if(!bodyItems.get(neighbor1Index + 1).startsWith("VAR")){
							bodyItems.add(item);
						}
					}		
				}						
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bodyItems.size(); i++) {
			sb.append(bodyItems.get(i));
		}
		return sb.toString();
	}

	public void removeRandomItem() {
		if (bodyItems.size() > 0) {
			bodyItems.remove(RandomUtil.getRandomNumberStartingFromZero(bodyItems.size()));
		}
	}

	

}
