package organizationtest;

import org.testng.annotations.Test;

import com.crm.vitiger.genericutility.BaseClass;
import com.crm.vitiger.objectrepository.CreateOrganizationpage;
import com.crm.vitiger.objectrepository.Homepage;
import com.crm.vitiger.objectrepository.OrganizationInfopage;
import com.crm.vitiger.objectrepository.Organizationpage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups="smoke testing")
	public void LoginOrganization() throws Throwable {
		// Read Test data/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + jLib.getRanDomNumber();

		
		/* Navigate to organization */
		Homepage hp = new Homepage(driver);
		hp.clickOnOrganizationLink();

		/* Navigate to Create organization */
		Organizationpage op = new Organizationpage(driver);
		op.createOrganizationImgage();

		/* Create organization */
		CreateOrganizationpage cop = new CreateOrganizationpage(driver);
		cop.createOrg(orgName);
		cop.SaveOrgButton();

		/* Verify Organization name */
		OrganizationInfopage orginfo = new OrganizationInfopage(driver);
		wLib.waitForElementToBeClickable(driver, orginfo.getActOrgName());
		String SuccessMsg = orginfo.ActOrgName();
		if (SuccessMsg.contains(orgName)) {
			System.out.println("Organization created successfully = Pass");
		} else {
			System.out.println("Organization page is failed to create = Fail");
		}

	}

}