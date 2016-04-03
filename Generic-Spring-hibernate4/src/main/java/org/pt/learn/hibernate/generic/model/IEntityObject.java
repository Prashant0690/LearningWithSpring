package org.pt.learn.hibernate.generic.model;

import java.io.Serializable;

public interface IEntityObject<k extends Serializable> extends Serializable{
	
	k getId();
}
