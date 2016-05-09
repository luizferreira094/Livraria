package controller;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Ouvinte implements PhaseListener {

	private static final long serialVersionUID = -7734463581933414102L;

	@Override
	public void afterPhase(PhaseEvent e) {
		System.out.println("After Phase : " + e.getPhaseId());
		FacesContext ctx = 
			FacesContext.getCurrentInstance();
		UIViewRoot vr = ctx.getViewRoot();
		String pagina = vr.getViewId();
		System.out.println("Pagina acessada : " + pagina);
		if (!pagina.equals("/login.xhtml")) { 
			Application app = ctx.getApplication();
			LoginMB lmb = app.evaluateExpressionGet(ctx, 
					"#{loginMB}", LoginMB.class);
			if (lmb.isLogado()) { 
				System.out.println("Esta logado pode prosseguir");
				
			} else { 
				System.out.println("Não esta logado, deve ir para a pagina login.xhtml");
				NavigationHandler nh = 
					app.getNavigationHandler();
				nh.handleNavigation(ctx, "", "login?faces-redirect= true");
				ctx.renderResponse();				
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent e) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
