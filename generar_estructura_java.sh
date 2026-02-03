#!/bin/bash

BASE_PACKAGE="utp/patrones"

echo "☕ Generando estructura Java por patrón..."

for dir in creacionales/* estructurales/* comportamiento/*; do
  if [ -d "$dir" ]; then

    PATRON=$(basename "$dir")
    PACKAGE_PATH="$dir/src/main/java/$BASE_PACKAGE/$PATRON"

    # Crear carpetas base
    mkdir -p "$PACKAGE_PATH"/{context,impl,strategy}

    MAIN_FILE="$PACKAGE_PATH/Main.java"

    # Crear Main.java si no existe
    if [ ! -f "$MAIN_FILE" ]; then
      cat > "$MAIN_FILE" << EOF
package utp.patrones.$PATRON;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejecutando patrón: $PATRON");
    }
}
EOF
      echo "✅ Estructura Java creada en $dir"
    else
      echo "⏭️  Estructura Java ya existe en $dir"
    fi

  fi
done

echo "🎉 Estructura Java generada correctamente."
