package com.hcid.partner.auth.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by yusep.maulana07 on 11/06/2019.
 */
@Data
@Entity
@Table(name = "TP_USER_ACTIVITY")
@DynamicUpdate
public class TippersLog  implements Serializable {

   
	private static final long serialVersionUID = 1353203053723784390L;

	
	@EmbeddedId
    private TippersLogChild tippersLogChild;

   

  
}
