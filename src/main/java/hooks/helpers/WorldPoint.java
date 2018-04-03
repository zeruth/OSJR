/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package hooks.helpers;

import hooks.accessors.Client;

/**
 * WorldPoint is a Three-Dimensional point representing the location of a Tile
 */
public class WorldPoint {
	/**
	 * Returns a WorldPoint containing the passed local coordinates
	 */
	public static WorldPoint fromLocal(Client client, int x, int y, int plane) {
		return new WorldPoint((x >>> Perspective.LOCAL_COORD_BITS) + Client.getBaseX(),
				(y >>> Perspective.LOCAL_COORD_BITS) + Client.getBaseY(), plane);
	}

	/**
	 * Returns a WorldPoint containing the passed LocalPoint
	 */
	public static WorldPoint fromLocal(Client client, LocalPoint local) {
		return fromLocal(client, local.getX(), local.getY(), Client.getPlane());
	}

	/**
	 * Returns a WorldPoint from the passed region coords
	 */
	public static WorldPoint fromRegion(Client client, int x, int y, int plane) {
		return new WorldPoint(x + Client.getBaseX(), y + Client.getBaseY(), plane);
	}

	public static boolean isInScene(Client client, int x, int y) {
		int baseX = Client.getBaseX();
		int baseY = Client.getBaseY();

		int maxX = baseX + Perspective.SCENE_SIZE;
		int maxY = baseY + Perspective.SCENE_SIZE;

		return x >= baseX && x < maxX && y >= baseY && y < maxY;
	}

	/**
	 * The plane coordinate of the Point.
	 */
	private final int plane;

	/**
	 * The X coordinate of the Point. Units are in tiles
	 */
	private final int x;

	/**
	 * The Y coordinate of the Point. Units are in tiles
	 */
	private final int y;

	public WorldPoint(int x, int y, int plane) {
		this.x = x;
		this.y = y;
		this.plane = plane;
	}

	/**
	 * Find the distance from this point to another point. Returns Integer.MAX_VALUE
	 * if other is on a different plane.
	 *
	 * @param other
	 * @return
	 */
	public int distanceTo(WorldPoint other) {
		if (other.plane != this.plane) {
			return Integer.MAX_VALUE;
		}

		return (int) Math.hypot(getX() - other.getX(), getY() - other.getY());
	}

	/**
	 * Find the distance from this point to another point.
	 *
	 * @param other
	 * @return
	 */
	public int distanceTo2D(WorldPoint other) {
		return (int) Math.hypot(getX() - other.getX(), getY() - other.getY());
	}

	public int getPlane() {
		// TODO Auto-generated method stub
		return this.plane;
	}

	int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	public boolean isInScene(Client client) {
		return Client.getPlane() == this.plane && isInScene(client, this.x, this.y);
	}

	@Deprecated
	public Point toPoint() {
		return new Point(this.x, this.y);
	}
}
