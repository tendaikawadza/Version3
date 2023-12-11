/**
 * Kumar.Kunal
 * parametrejdbc
 * com.org.kunal.parametrejdbc.purchaserequest
 */
package io.getarrays.securecapita.purchaserequestnew;

import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Kumar.Kunal
 */
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Table

public class PurchaseRequestEntity {
	
	//@Id
	private long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date purchaseDate;
	private  String purchase_requestNumber;
	private  String requestingDepartment;
	private int departmentCode;
	private String requestReason;
	private int itemNumber;
	private String itemDescription;
	private int unitPrice;
	private int quantity;
	private int estimatedValue;
	private String emailAddress;
	
	private String name;
	private String type;
	
	//@Column(name = "profileImage", nullable = false, columnDefinition = "BINARY(256)", length = 256)
	@Lob
	private byte[] profileImage;

	@PrePersist
	private void generatePurchaseRequestNumber() {
		StringBuilder sb = new StringBuilder();
		sb.append("PR");
		sb.append(System.currentTimeMillis()); // Append a timestamp
		sb.append((int) (Math.random() * 10000)); // Append a random number between 0 and 9999
		this.purchase_requestNumber = sb.toString();
	}



}
