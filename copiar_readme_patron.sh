#!/bin/bash

TEMPLATE="README_PATRON_TEMPLATE.md"

if [ ! -f "$TEMPLATE" ]; then
  echo "❌ No se encontró $TEMPLATE en la raíz del proyecto"
  exit 1
fi

echo "📝 Copiando README.md a cada patrón..."

for dir in creacionales/* estructurales/* comportamiento/*; do
  if [ -d "$dir" ]; then
    README="$dir/README.md"

    if [ ! -f "$README" ]; then
      cp "$TEMPLATE" "$README"
      echo "✅ README copiado en $dir"
    else
      echo "⏭️  README ya existe en $dir"
    fi
  fi
done

echo "🎉 Proceso finalizado correctamente."
