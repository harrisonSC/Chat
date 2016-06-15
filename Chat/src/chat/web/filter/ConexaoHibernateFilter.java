package chat.web.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chat.util.JPAUtil;

public class ConexaoHibernateFilter implements Filter{
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
	
			throws IOException, ServletException {
		EntityManager sf = null;
		try {
			sf = JPAUtil.getEntityManager();
			sf.getTransaction().begin();
			chain.doFilter(servletRequest, servletResponse);
			sf.getTransaction().commit();
			
		} catch (Throwable ex) {
			try {
				if (sf != null && sf.isOpen()) {
					sf.getTransaction().rollback();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			throw new ServletException(ex);
		}finally {
			if (sf != null){
			sf.close();
			}
		}
		
	}


	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
