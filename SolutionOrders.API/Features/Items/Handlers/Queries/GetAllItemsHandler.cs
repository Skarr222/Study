using MediatR;
using Microsoft.EntityFrameworkCore;
using SolutionOrders.API.Features.Items.Messages.DTOs;
using SolutionOrders.API.Models.Data;

namespace SolutionOrders.API.Features.Items.Queries.GetAllItems
{
    public class GetAllItemsHandler : IRequestHandler<GetAllItemsQuery, List<ItemDto>>
    {
        private readonly ApplicationDbContext _context;

        // Dependency Injection - DbContext
        public GetAllItemsHandler(ApplicationDbContext context)
        {
            _context = context;
        }

        // Handle = główna metoda
        public async Task<List<ItemDto>> Handle(
            GetAllItemsQuery request,
            CancellationToken cancellationToken
        )
        {
            // Query do bazy z Include (EAGER LOADING)
            var items = await _context
                .Items.Include(i => i.Category) // JOIN z Category
                .AsNoTracking() // Tylko do odczytu, bez śledzenia zmian
                .Include(i => i.UnitOfMeasurement) // JOIN z UnitOfMeasurement
                .Where(i => i.IsActive) // Tylko aktywne
                .OrderBy(i => i.Name) // Sortowanie
                .Select(i => new ItemDto // Projekcja do DTO
                {
                    IdItem = i.IdItem,
                    Name = i.Name,
                    Description = i.Description,
                    IdCategory = i.IdCategory,
                    CategoryName = i.Category.Name,
                    Price = i.Price,
                    Quantity = i.Quantity,
                    IdUnitOfMeasurement = i.IdUnitOfMeasurement,
                    UnitName = i.UnitOfMeasurement != null ? i.UnitOfMeasurement.Name : null,
                    Code = i.Code,
                    IsActive = i.IsActive,
                })
                .ToListAsync(cancellationToken);

            return items;
        }
    }
}
