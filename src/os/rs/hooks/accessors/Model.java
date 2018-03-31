package os.rs.hooks.accessors;

import java.util.ArrayList;
import java.util.List;

import os.rs.hooks.Hooks;
import os.rs.hooks.helpers.Triangle;
import os.rs.hooks.helpers.Vertex;
import os.rs.hooks.model.RSClass;

public class Model extends RSClass {

	public Model(Object reference) {
		this.reference = reference;
		if (Hooks.model != null) {
			this.fields = Hooks.model.fields;
			this.name = Hooks.model.name;
			this.obfuscatedName = Hooks.model.obfuscatedName;
		}
	}

	public List<Triangle> getTriangles() {
		if (getVertices() != null) {
			int[] trianglesX = getTrianglesX();
			int[] trianglesY = getTrianglesY();
			int[] trianglesZ = getTrianglesZ();

			List<Vertex> vertices = getVertices();
			List<Triangle> triangles = new ArrayList<Triangle>(getTrianglesCount());

			for (int i = 0; i < getTrianglesCount(); ++i) {
				int triangleX = trianglesX[i];
				int triangleY = trianglesY[i];
				int triangleZ = trianglesZ[i];

				Triangle triangle = new Triangle(vertices.get(triangleX), vertices.get(triangleY),
						vertices.get(triangleZ));
				triangles.add(triangle);
			}

			return triangles;
		}
		return null;
	}

	private int getTrianglesCount() {
		// TODO Auto-generated method stub
		return (int) getValue(getField("indicesCount"));
	}

	private int[] getTrianglesX() {
		// TODO Auto-generated method stub
		return (int[]) getValue(getField("indices1"));
	}

	private int[] getTrianglesY() {
		// TODO Auto-generated method stub
		return (int[]) getValue(getField("indices2"));
	}

	private int[] getTrianglesZ() {
		// TODO Auto-generated method stub
		return (int[]) getValue(getField("indices3"));
	}

	public List<Vertex> getVertices() {
		if (getValue(getField("verticesCount")) != null) {
			int[] verticesX = getVerticesX();
			int[] verticesY = getVerticesY();
			int[] verticesZ = getVerticesZ();

			List<Vertex> vertices = new ArrayList<Vertex>();

			for (int i = 0; i < getVerticesCount(); ++i) {
				Vertex v = new Vertex(verticesX[i], verticesY[i], verticesZ[i]);
				vertices.add(v);
			}
			return vertices;
		}
		return null;
	}

	private int getVerticesCount() {
		return (int) getValue(getField("verticesCount"));
	}

	private int[] getVerticesX() {
		return (int[]) getValue(getField("verticesX"));
	}

	private int[] getVerticesY() {
		return (int[]) getValue(getField("verticesY"));
	}

	private int[] getVerticesZ() {
		return (int[]) getValue(getField("verticesZ"));
	}

}
