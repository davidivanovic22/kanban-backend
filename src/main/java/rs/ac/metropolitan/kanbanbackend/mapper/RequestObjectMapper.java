package rs.ac.metropolitan.kanbanbackend.mapper;

import javax.servlet.http.HttpServletRequest;

public class RequestObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {

		public <T> T readClass(HttpServletRequest request, Class<T> clazz) {
			try {
				return clazz.cast(readValue(request.getInputStream(), clazz));
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
