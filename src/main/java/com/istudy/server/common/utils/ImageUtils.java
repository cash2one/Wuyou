package com.istudy.server.common.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageUtils {

	/**
	 * 裁切图片
	 * 
	 * @param source
	 *            原图
	 * @param startX
	 *            起始X
	 * @param startY
	 *            起始Y
	 * @param width
	 *            裁切宽
	 * @param height
	 *            裁切高
	 * @return
	 */
	public static BufferedImage getSubBufferedImage(BufferedImage source,
			int startX, int startY, int width, int height) {
		if (width + startX > source.getWidth()) {
			width = source.getWidth() - startX;
		}
		if (height + startY > source.getHeight()) {
			height = source.getHeight() - startY;
		}
		return source.getSubimage(startX, startY, width, height);
	}

	/**
	 * 调整Bufferedimage大小
	 * 
	 * @param source
	 *            BufferedImage 原始image
	 * @param targetW
	 *            int 目标宽
	 * @param targetH
	 *            int 目标高
	 * @param isRatio
	 *            boolean 是否同比例调整
	 * @return BufferedImage 返回新image
	 */
	public static BufferedImage resizeBufferedImage(BufferedImage source,
			int targetW, int targetH, boolean isRatio) {
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		if (isRatio && sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else if (isRatio && sx <= sy) {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) {
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
					targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else {
			target = new BufferedImage(targetW, targetH, type);
		}
		Graphics2D g = target.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

}
