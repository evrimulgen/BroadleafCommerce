package org.broadleafcommerce.openadmin.client.view.dynamic.form;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.VStack;
import org.broadleafcommerce.openadmin.client.datasource.dynamic.DynamicEntityDataSource;
import org.broadleafcommerce.openadmin.client.presenter.entity.FormItemCallback;

/**
 * Created by IntelliJ IDEA.
 * User: jfischer
 * Date: 9/13/11
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArtifactItem extends CanvasItem {

    private Img previewImg;

    public ArtifactItem() {
        VStack allStack = new VStack();
        allStack.setWidth(60);
        allStack.setAlign(Alignment.CENTER);
        VStack previewContainer = new VStack();
        allStack.addMember(previewContainer);
        previewContainer.setWidth(60);
        previewContainer.setHeight(60);
        previewContainer.setBorder("1px solid #a6abb4");
        previewImg = new Img();
        previewImg.setImageType(ImageStyle.CENTER);
        previewImg.setVisible(true);
        previewContainer.addChild(previewImg);
        IButton imageUpdateButton = new IButton("Update Artifact");
        final FormItem formItem = this;
        imageUpdateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final String formItemName = formItem.getName();
            	((FormItemCallback) ((DynamicEntityDataSource) formItem.getForm().getDataSource()).getFormItemCallbackHandlerManager().getFormItemCallback(formItemName)).execute(formItem);
            }
        });
        allStack.addMember(imageUpdateButton);

        setCanvas(allStack);
    }

    public void setPreviewSrc(String value) {
        previewImg.setSrc("../" + value);
    }

}
