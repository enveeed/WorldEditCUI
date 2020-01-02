package com.mumfrey.worldeditcui.event.listeners;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mumfrey.worldeditcui.WorldEditCUI;
import com.mumfrey.worldeditcui.util.Vector3;
import net.minecraft.client.MinecraftClient;

/**
 * Listener for WorldRenderEvent
 * 
 * @author lahwran
 * @author yetanotherx
 * @author Adam Mummery-Smith
 */
public class CUIListenerWorldRender
{
	private WorldEditCUI controller;
	
	private MinecraftClient minecraft;
	
	public CUIListenerWorldRender(WorldEditCUI controller, MinecraftClient minecraft)
	{
		this.controller = controller;
		this.minecraft = minecraft;
	}
	
	public void onRender(float partialTicks)
	{
		try
		{
			// Thanks to @enveeed
			RenderSystem.enableDepthTest();
			RenderSystem.shadeModel(7425);
			RenderSystem.enableAlphaTest();
			RenderSystem.defaultAlphaFunc();
			RenderSystem.disableTexture();
			RenderSystem.disableBlend();
			RenderSystem.lineWidth(1.0F);
			/*
			GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, 240F, 240F);
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GlStateManager.enableBlend();
			GlStateManager.enableAlphaTest();
			GlStateManager.alphaFunc(GL11.GL_GREATER, 0.0F);
			GlStateManager.disableTexture();
			GlStateManager.enableDepthTest();
			GlStateManager.depthMask(false);
			GlStateManager.pushMatrix();
			GlStateManager.disableFog();
			 */
			
			try
			{
				Vector3 cameraPos = new Vector3(this.minecraft.gameRenderer.getCamera().getPos());
				Vector3 playerPos = new Vector3(this.minecraft.player.getPos());
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
				this.controller.renderSelections(cameraPos, playerPos, partialTicks);
			}
			catch (Exception e)
			{
			}

			// Thanks to @enveeed
			RenderSystem.lineWidth(1.0F);
			RenderSystem.enableBlend();
			RenderSystem.enableTexture();
			RenderSystem.shadeModel(7424);
			/*
			GlStateManager.depthFunc(GL11.GL_LEQUAL);
			GlStateManager.popMatrix();

			GlStateManager.depthMask(true);
			GlStateManager.enableTexture();
			GlStateManager.disableBlend();
			GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
			*/
		}
		catch (Exception ex) {}
	}
}
