package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ModelTableProvider;
import Model.Entity.Provider;
import View.CreateProviderPanel;

public class CreateProviderButtonListener implements ActionListener
{
    private CreateProviderPanel ui;

    public CreateProviderButtonListener(CreateProviderPanel ui)
    {
        this.ui = ui;
    }

    public void actionPerformed(ActionEvent e)
    {
        String name = ui.textFieldName.getText();
        String address = ui.textFieldAddress.getText();
        String phoneNumber = ui.textFieldPhoneNumber.getText();

        if(name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty())
        {
            ui.labelError.setText("You have to fill all the properties !");
        }
        else
        {
            for(Provider provider : ui.providerList)
            {
                if(provider.getName().equals(name))
                {
                    ui.labelError.setText("Type already exists !");
                    return;
                }
            }
            Provider newprovider = new Provider(name, address, phoneNumber);
            ui.providerList.add(newprovider); // Add the new provider to the list
            ui.parent.employeeArticlePanel.addArticlePanel.providerComboBoxModel.addElementAndUpdate(newprovider); // Prevent the combo box
            // Prevent the Jtable
            ModelTableProvider tm = (ModelTableProvider) ui.parent.employeeProviderPanel.viewProviderPanel.tableProvider.getModel();
            tm.fireTableDataChanged(); // Prevent

            ui.labelError.setText("Type created !");
        }
    }
}