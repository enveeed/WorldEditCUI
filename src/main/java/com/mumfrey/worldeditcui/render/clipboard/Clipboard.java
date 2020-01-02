package com.mumfrey.worldeditcui.render.clipboard;

import com.mumfrey.worldeditcui.render.ConfiguredColour;
import com.mumfrey.worldeditcui.render.shapes.Render3DBox;
import com.mumfrey.worldeditcui.util.Vector3;

public class Clipboard {

    private Render3DBox outline;

    private int dim_x = -1;
    private int dim_y = -1;
    private int dim_z = -1;

    private int offset_x = -1;
    private int offset_y = -1;
    private int offset_z = -1;

    // NOTE: For now, only render an outline as we don't read the nbt data yet.

    public void render(Vector3 cameraPos, Vector3 playerPos, float partialTicks) {

        if(dim_x <= 0 || dim_y <= 0 || dim_z <= 0) return; // do not render empty clipboards

        Vector3 playerPosBlock = playerPos.floor();
        Vector3 offset = new Vector3(offset_x, offset_y, offset_z);
        Vector3 dimensions = new Vector3(dim_x, dim_y, dim_z);

        // offset = minimum - origin
        // minimum = offset + origin (player pos block)

        Vector3 min = offset.add(playerPosBlock);
        Vector3 max = min.add(dimensions);

        if(this.outline == null) {
            this.outline = new Render3DBox(ConfiguredColour.CLIPBOARDGRID.style(), min, max);
        }
        else this.outline.setPosition(min, max);

        //

        this.outline.render(cameraPos);
    }



    //

    public void updateData(int dim_x, int dim_y, int dim_z,
                        int offset_x, int offset_y, int offset_z) {
        this.dim_x = dim_x;
        this.dim_y = dim_y;
        this.dim_z = dim_z;
        this.offset_x = offset_x;
        this.offset_y = offset_y;
        this.offset_z = offset_z;
    }
}
