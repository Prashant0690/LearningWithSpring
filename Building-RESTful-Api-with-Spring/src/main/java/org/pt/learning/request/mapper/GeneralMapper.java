package org.pt.learning.request.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.pt.learning.entity.Blog;
import org.pt.learning.rest.request.BlogRequest;
import org.pt.learning.rest.request.BlogUpdateRequest;

@Mapper
public interface GeneralMapper {
	
	GeneralMapper INSTANCE = Mappers.getMapper( GeneralMapper.class );
	
	Blog requestToEntity(BlogRequest blogRequest);
	
	void updateBlogUpdateResponseToBlogEntity(BlogUpdateRequest updateRequest, @MappingTarget Blog blog);
	
	/*TestEntity requestToEntity(TestEntityRequest request);
	
	ClientUsers requestToEntity(ClientUsersRequest request);
	
	Doctor requestToEntity(DoctorRequest request);
	
	DoctorWork requestToEntity(DoctorWorkRequest request);
	
	Prescription requestToEntity(PrescriptionRequest request);
	
	PrescriptionDrugs requestToEntity(PrescriptionDrugsRequest request);
	
	UserHealth requestToEntity(UserHealthRequest request);
	
	UserInfo requestToEntity(UserInfoRequest request);
	
	Users requestToEntity(UsersRequest request);
	
	MedicalConsultation requestToEntity(MedicalConsultationRequest request);*/
	
	

}
