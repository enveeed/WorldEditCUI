package com.mumfrey.worldeditcui.event.cui;

import com.mumfrey.worldeditcui.event.CUIEvent;
import com.mumfrey.worldeditcui.event.CUIEventArgs;
import com.mumfrey.worldeditcui.event.CUIEventType;
import com.mumfrey.worldeditcui.render.clipboard.Clipboard;

public class CUIEventClipboard extends CUIEvent {

    public CUIEventClipboard(CUIEventArgs args) {
        super(args);
    }

    @Override
    public CUIEventType getEventType() {
        return CUIEventType.CLIPBOARD;
    }

    @Override
    public String raise() {

        int dim_x = this.getInt(0);
        int dim_y = this.getInt(1);
        int dim_z = this.getInt(2);
        int offset_x = this.getInt(3);
        int offset_y = this.getInt(4);
        int offset_z = this.getInt(5);

        // NOTE: Ignore for now, useful later
        // String contentBase64 = this.getString(6);

        Clipboard clipboard = this.controller.getClipboard();

        clipboard.updateData(dim_x, dim_y, dim_z, offset_x, offset_y, offset_z);

        return null;
    }

}
