package org.pt.learn.hibernate.generic.model;

import java.io.Serializable;

public abstract class EntityObject<k extends Serializable> implements IEntityObject<k>  {
	

	@Override
	public int hashCode() {
		return (Integer) (this.getId() != null ? this.getId() : super.hashCode());
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this.getClass() == obj.getClass()){
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()){
			return false;
		}
		IEntityObject<k> entityObject = (IEntityObject<k>)obj;
		return this.getId() == entityObject.getId();
	}

}
