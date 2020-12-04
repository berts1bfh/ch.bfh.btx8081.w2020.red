package view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;


@Route("InstructionMgmtView")
public class InstructionMgmtView  extends AppLayout{

    public InstructionMgmtView() {


	setPrimarySection(AppLayout.Section.DRAWER);
	Image img = new Image("https://i.imgur" +	".com/GPpnszs.png", "Vaadin Logo");
	img.setHeight("44px");
	addToNavbar(new DrawerToggle(), img);
	Tabs tabs = new Tabs(new Tab("Home"),
		new Tab("About"));
	tabs.setOrientation(Tabs.Orientation.VERTICAL);
	addToDrawer(tabs);
    }
}


