package co.commandyourmoney.backend.model;

import org.bson.types.ObjectId;

import lombok.Data;
import lombok.Setter;
import lombok.AccessLevel;

@Data
public class Transaction {

	@Setter(AccessLevel.NONE)
	public ObjectId id = ObjectId.get();

	private String merchant;
	private String date;
	private int amount;
	
	// possibly add allocation
	//   amount
	//   date
	//   merchant
	//   whole: boolean
	//   label: Budget-item name

	public Transaction() {
	}

	public Transaction(String name, String date, String merchant, int amount) {
		this.merchant = merchant;
		this.date = date;
		this.amount = amount;
	}


}
